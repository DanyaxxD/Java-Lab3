package edu.mde.lab2;

import java.text.NumberFormat;

public class Sqrt implements Function
{
    final private Function fx;
    private final double index;

    public Sqrt(Function fx,double index) {
        this.fx = fx;
        this.index = index;
    }

    public double calculate(double x) {
        return Math.pow(fx.calculate(x),1/index);
    }

    @Override
    public Function derivative() {
        return Multiplication.of(Multiplication.of(Const.ONE,Power.of(Multiplication.of(Const.of(index),Sqrt.of(Power.of(fx,index-1),index)),-1)),fx.derivative());
    }

    public static Sqrt of(Function fx,double index) {
        return new Sqrt(fx,index);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sqrt("+fx.toPrettyString(nf)+","+ index +")";
    }
}
