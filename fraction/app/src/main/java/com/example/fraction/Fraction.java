package com.example.fraction;

class Fraction {
    int numerator, denominator;

    Fraction(){}

    Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }

    public static Fraction sum(Fraction f1, Fraction f2){
        Fraction result = new Fraction(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static Fraction difference(Fraction f1, Fraction f2){
        Fraction result = new Fraction(f1.numerator * f2.denominator - f2.numerator * f1.denominator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static Fraction multiplication(Fraction f1, Fraction f2){
        Fraction result = new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
        return result.simplify();
    }

    public static Fraction divide(Fraction f1, Fraction f2){
        Fraction result = new Fraction(f1.numerator * f2.denominator, f1.denominator * f2.numerator);
        return result.simplify();
    }

    private Fraction simplify() {
        int limit = Math.min(Math.abs(numerator), Math.abs(denominator));
        for (long i = 2; i <= limit; i++)
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
                i = 2;
            }
        return this;
    }
}
