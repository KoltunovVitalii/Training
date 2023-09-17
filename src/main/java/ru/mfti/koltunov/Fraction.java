package ru.mfti.koltunov;

import java.util.Objects;


public final class Fraction extends Number implements Cloneable {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель не может быть <= 0!");
        }
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Числитель / знаменатель:" + " " + numerator + " / " + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //      a / b    c / d
//1)произведение дробей a*c/b*d
//2)деление дробей a*d/b*c
//3)сложение (a*d+c*b)/(b*d))
//4)вычитание(a*d-c*b)/(b*d))

    //сумма дробей
    public Fraction sum(Fraction y) {
        int numerator = this.numerator * y.denominator + y.numerator * this.denominator;
        int denominator = this.denominator * y.denominator;
        return new Fraction(numerator, denominator);
    }
    //разница дробей
    public Fraction sub(Fraction y) {
        int numerator = this.numerator * y.denominator - y.numerator * this.denominator;
        int denominator = this.denominator * y.denominator;
        return new Fraction(numerator, denominator);
    }

    //произведение дробей
    public Fraction mul(Fraction y) {
        int numerator = this.numerator * y.numerator;
        int denominator = this.denominator * y.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction div(Fraction y) {
        int numerator = this.numerator * y.denominator;
        int denominator = this.denominator * y.numerator;
        return new Fraction(numerator, denominator);
    }

    @Override
    public Fraction clone() throws CloneNotSupportedException{
        return (Fraction) super.clone();
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double)numerator / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumerator(), getDenominator());
    }
}
