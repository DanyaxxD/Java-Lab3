package edu.mde.lab2;

import java.text.NumberFormat;

public class Ctg implements Function{

    private final Function fx;

    public Ctg(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return 1 / Math.tan(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return Multiplication.of(Const.NEGATIVE_ONE, Multiplication.of(fx.derivative(), Power.of(Sin.of(fx), -2)));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "ctg(" + fx.toPrettyString(nf) + ")";
    }

    public static Ctg of(Function fx) {
        return new Ctg(fx);
    }
}
