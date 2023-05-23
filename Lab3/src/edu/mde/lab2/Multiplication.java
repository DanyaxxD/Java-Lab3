package edu.mde.lab2;

import java.text.NumberFormat;

public class Multiplication implements Function {
    private final Function first;
    private final Function second;
    public Multiplication(Function first, Function second)
    {
        this.first=first;
        this.second=second;
    }

    @Override
    public double calculate(double x){
        return first.calculate(x)*second.calculate(x);
    }

    @Override
    public Function derivative() {
        return Sum.of(Multiplication.of(first.derivative(),second),Multiplication.of(first,second.derivative()));
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "("+first.toPrettyString(nf)+"*"+second.toPrettyString(nf)+")";
    }

    public static Multiplication of(Function first, Function second)
    {
        return new Multiplication(first, second);
    }
}
