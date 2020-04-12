package com.example.fraction;

class Fraction {
    int numerator, denominator, wholePart = 0;

    Fraction(){}

    Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }

    public static Object sum(Fraction f1, Fraction f2, Boolean displayMode){
        Fraction result = new Fraction(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        if(displayMode)
            return result.simplify();
        else
            return (double)result.numerator/(double)result.denominator;
    }

    public static Object difference(Fraction f1, Fraction f2, Boolean displayMode){
        Fraction result = new Fraction(f1.numerator * f2.denominator - f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        if(displayMode)
            return result.simplify();
        else
            return (double)result.numerator/(double)result.denominator;
    }

    public static Object multiplication(Fraction f1, Fraction f2, Boolean displayMode){
        Fraction result = new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
        if(displayMode)
            return result.simplify();
        else
            return (double)result.numerator/(double)result.denominator;
    }

    public static Object divide(Fraction f1, Fraction f2, Boolean displayMode){
        Fraction result = new Fraction(f1.numerator * f2.denominator, f1.denominator * f2.numerator);
        if(displayMode)
            return result.simplify();
        else
            return (double)result.numerator/(double)result.denominator;
    }

    private Fraction simplify() {
        int limit = Math.min(Math.abs(numerator), Math.abs(denominator));
        for (long i = 2; i <= limit; i++)
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
                i = 2;
            }
        if (numerator/denominator != 0) {
            wholePart = numerator/denominator;
            numerator %= denominator;
        }
        return this;
    }
}
