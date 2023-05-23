package edu.mde.lab2;

import java.text.NumberFormat;

public class Abs implements edu.mde.lab2.Function {

    private final Function fx;

    public Abs(Function fx) {

        this.fx = fx;
    }

    @Override
    public double calculate(double x) {

        return Math.abs(fx.calculate(x));
    }

    @Override
    public edu.mde.lab2.Function derivative() {
        return new edu.mde.lab2.Multiplication(new edu.mde.lab2.Multiplication(fx, new edu.mde.lab2.Power( new Abs(fx), -1)), fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {

        return "abs(" + fx.toPrettyString(nf) + ")";
    }

    public static Abs of(edu.mde.lab2.Function fx) {

        return new Abs(fx);
    }
}