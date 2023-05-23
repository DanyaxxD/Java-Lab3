package edu.mde.lab2;

import java.text.NumberFormat;

public class Logn implements Function{
    private final Function fx;

    public Logn(Function fx){

        this.fx=fx;
    }
    @Override
    public double calculate(double x) {

        return Math.log(fx.calculate(x));
    }

    @Override
    public Function derivative() {

        return new Multiplication(new Power(fx, -1),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {

        return "log("+fx.toPrettyString(nf)+")";
    }

    public static Logn of(Function fx){

        return new Logn(fx);
    }
}