package Classes;

// КЛАСС НЕКОТОРЫХ АРИФМЕТИЧЕСКИХ ОПЕРАЦИЯ
public class Arithmetic {
    // Определение НОД числа (алгоритм Евклида)
    public static int defineGCD(int x, int y) {
        if (x == 0 || y == 0) {
            return  1;
        }

        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        return x;
    }

    // Сложение дробей
    public static Fraction addition(Fraction frac1, Fraction frac2) {
        // получение вводных данных
        String initial = "(" + frac1.getInitial() + ") + (" + frac2.getInitial() + ")";
        // получение полной формы числителя результатирующей дроби
        int numerator = frac1.getFullNumerator() * frac2.getDenominator() +
                        frac2.getFullNumerator() * frac1.getDenominator();
        // получение полной формы знаменателя результатирующей дроби
        int denominator = frac1.getDenominator() * frac2.getDenominator();
        // результатирующая дробь
        Fraction frac = new Fraction(numerator, denominator);
        // возвращение результатирующей дроби
        return new Fraction(frac, initial);
    }

    // Разность дробей
    public static Fraction subtraction(Fraction frac1, Fraction frac2) {
        // получение вводных данных
        String initial = "(" + frac1.getInitial() + ") - (" + frac2.getInitial() + ")";
        // получение полной формы числителя результатирующей дроби
        int numerator = frac1.getFullNumerator() * frac2.getDenominator() -
                        frac2.getFullNumerator() * frac1.getDenominator();
        // получение полной формы знаменателя результатирующей дроби
        int denominator = frac1.getDenominator() * frac2.getDenominator();
        // результатирующая дробь
        Fraction frac = new Fraction(numerator, denominator);
        // возвращение результатирующей дроби
        return new Fraction(frac, initial);
    }

    // Умножение дробей
    public static Fraction multiplication(Fraction frac1, Fraction frac2) {
        // получение вводных данных
        String initial = "(" + frac1.getInitial() + ") * (" + frac2.getInitial() + ")";
        // получение полной формы числителя результатирующей дроби
        int numerator = frac1.getFullNumerator() * frac2.getFullNumerator();
        // получение полной формы знаменателя результатирующей дроби
        int denominator = frac1.getDenominator() * frac2.getDenominator();
        // результатирующая дробь
        Fraction frac = new Fraction(numerator, denominator);
        // возвращение результатирующей дроби
        return new Fraction(frac, initial);
    }

    // Деление дробей
    public static Fraction division(Fraction frac1, Fraction frac2) {
        // получение вводных данных
        String initial = "(" + frac1.getInitial() + ") / (" + frac2.getInitial() + ")";
        // исключение попыток сохранение знаменателя со значением 0
        if (frac2.getFullNumerator() == 0) {
            throw new ArithmeticException("Числитель второй дроби не может быть равен нулю!");
        }
        // получение полной формы числителя результатирующей дроби
        int numerator = frac1.getFullNumerator() * frac2.getDenominator();
        // получение полной формы знаменателя результатирующей дроби
        int denominator = frac1.getDenominator() * frac2.getFullNumerator();
        // результатирующая дробь
        Fraction frac = new Fraction(numerator, denominator);
        // возвращение результатирующей дроби
        return new Fraction(frac, initial);
    }
}