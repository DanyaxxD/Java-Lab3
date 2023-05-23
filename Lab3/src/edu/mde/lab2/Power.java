package edu.mde.lab2;

import java.text.NumberFormat;

public class Power implements Function {
    private final Function fx;
    private final double index;

    public Power(Function fx, double index) {
        this.fx = fx;
        this.index = index;
    }

    public static Function of(Sinh sinhFunction) {
        return new Power(sinhFunction, 1.0);
    }
    @Override
    public double calculate(double x) {
        return Math.pow(fx.calculate(x), index);
    }

    @Override
    public Function derivative() {
        return Multiplication.of(Multiplication.of(Const.of(index), Power.of(fx, index - 1)), fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "(" + fx.toPrettyString(nf) + ")^" + index;
    }

    public static Power of(Function fx, double index) {
        return new Power(fx, index);
    }
}