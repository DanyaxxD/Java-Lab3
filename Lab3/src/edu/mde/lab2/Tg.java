package edu.mde.lab2;

import java.text.NumberFormat;

public class Tg implements Function {

    private final Function fx;

    public Tg(Function fx) {

        this.fx = fx;
    }

    @Override
    public double calculate(double x) {

        return Math.tan(fx.calculate(x));
    }

    @Override
    public Function derivative() {

        return Multiplication.of(fx.derivative(), Power.of(Cos.of(fx), -2));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {

        return "tan(" + fx.toPrettyString(nf) + ")";
    }

    public static Tg of(Function fx) {
        return new Tg(fx);
    }
}