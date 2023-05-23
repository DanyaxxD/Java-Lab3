package edu.mde.lab2;

import java.text.NumberFormat;

public class Linear implements Function {
    public static final Linear X = new Linear(1.0) {
        @Override
        public String toPrettyString(NumberFormat nf) {return "x";}
    };
    private final double coef;
    public Linear(double coefficient) {this.coef = coefficient;}
    @Override
    public double calculate(double x) {return x * coef;}
    @Override
    public Function derivative() {return new Const(coef);}
    @Override
    public String toPrettyString(NumberFormat nf) {return String.format("%s*x", nf.format(coef));}
    public static Linear of(double coefficient) {return new Linear(coefficient);}}