package Classes;

// КЛАСС СМЕШАННОЙ ДРОБИ
public class Fraction {
    // строка с исходными данными
    private String initial;
    // целая часть дроби
    private int integer;
    // числитель
    private int numerator;
    // знаменатель
    private int denominator;
    // знак дроби
    private boolean isNegative;


    // КОНСТРУКТОРЫ
    // Конструктор дроби по умолчанию
    public Fraction() {
        // определение вводных данных
        initial = "";
        // определение целой части
        integer = 0;
        // определение числителя
        numerator = 0;
        // определение знаменателя
        denominator = 1;
        // определение знака дроби
        isNegative = false;
    }

    // Конструктор дроби из целого числа
    public Fraction(int integer) {
        // создание дроби
        this();
        // сохранение вводных данных
        initial = integer + "";
        // сохранение целой части
        this.integer = integer;
        // унификация знака дроби
        bringSign();
    }

    // Конструктор дроби из целочисленных значений числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        // делегирование конструктора
        this(0, numerator, denominator);
        // сохранение вводных данных
        initial = numerator + "/" +
                  (denominator < 0 ? "(" + denominator + ")" : denominator);
    }

    // Конструктор дроби из целого числа и целочисленных значений числителя и знаменателя
    public Fraction(int integer, int numerator, int denominator) {
        // исключение попыток сохранение знаменателя со значением 0
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель дроби не может быть равен нулю!");
        }
        // сохранение исходных данных
        initial = integer + " " +
                  numerator + "/" +
                  (denominator < 0 ? "(" + denominator + ")" : denominator);
        // сохранение целой части
        this.integer = integer;
        // сохранение числителя
        this.numerator = numerator;
        // сохранение знаменателя
        this.denominator = denominator;
        // определение знака дроби
        isNegative = false;
        // унификация знака дроби
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Конструктор дроби из вещественного числа
    public Fraction(double number) {
        // сохранение вводных данных
        initial = number + "";
        // сохранения знака дроби
        isNegative = number < 0;
        // получение абсолютного значение числа
        number = Math.abs(number);
        // получение целой части дроби
        integer = (int)number;
        // получение строкового представления числа
        String numberStr = String.valueOf(number);
        // получение строкового представления числителя
        String numeratorStr = numberStr.split("[.]")[1];
        // получение числителя
        numerator = Integer.parseInt(numeratorStr);
        // определение количества цифр (разрядности) в числителе
        int bitDepth = numeratorStr.length();
        // получение знаменателя
        denominator = (int)Math.pow(10, bitDepth);
        // сокращение дроби
        reductionFrac();
    }

    // Конструктор дроби из строкового представления числа
    public Fraction(String numberStr) {
        // сохранение вводных данных
        initial = numberStr + "";
        // определение знака дроби
        isNegative = false;

        // получение дроби из строкового представления дроби
        if (numberStr.contains("/")) {
            // получение массива частей числа
            String[] arrNumber = numberStr.split("/");
            // получение целой части дроби и его числителя
            String numeratorStr = arrNumber[0];

            if (numeratorStr.contains(" ")) {
                // получение массива из целой части дроби и числителя
                String[] arrNumerator = numeratorStr.split(" ");
                // получение целой части дроби
                integer = Integer.parseInt(arrNumerator[0]);
                // получение числителя
                numerator = Integer.parseInt(arrNumerator[1]);
            } else {
                // определение целой части дроби
                integer = 0;
                // получение числителя
                numerator = Integer.parseInt(numeratorStr);
            }

            // получение знаменателя
            denominator = Integer.parseInt(arrNumber[1]);
            // исключение попыток сохранение знаменателя со значением 0
            if (denominator == 0) {
                throw new ArithmeticException("Знаменатель дроби не может быть равен нулю!");
            }
            // получение дроби из строкового представления вещественного числа
        } else if (numberStr.contains(".")) {
            // получение массива целой и дробной части числа
            String[] arrNum = numberStr.split("[.]");
            // получение целой части дроби
            integer = Integer.parseInt(arrNum[0]);
            // получение строкового представления числителя
            String numeratorStr = arrNum[1];
            // получение числителя
            numerator = Integer.parseInt(numeratorStr);
            // определение количества цифр (разрядности) в числителе
            int bitDepth = numeratorStr.length();
            // получение знаменателя
            denominator = (int)Math.pow(10, bitDepth);
        } else {
            // сохранение целой части
            integer = Integer.parseInt(numberStr);
            // определение числителя
            numerator = 0;
            // определение знаменателя
            denominator = 1;
        }

        // унификация знака дроби
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Конструктор дроби с добавлением строки с вводными данными
    public Fraction(Fraction frac, String initial) {
        this.initial = initial;
        this.integer = frac.getAbsInteger();
        this.numerator = frac.getNumerator();
        this.denominator = frac.getDenominator();
        this.isNegative = frac.isNegative();
    }


    // СЛУЖЕБНЫЕ (ПРИВАТНЫЕ) МЕТОДЫ
    // Получение множителя, соответствующему знаку дроби
    private int getSignMultiplier() {
        return isNegative ? -1 : 1;
    }

    // Получение строкового знака дроби
    private String getSign() {
        return isNegative ? "-" : "";
    }

    // Унификация знака числа
    private void bringSign() {
        if (integer < 0) {
            // изменение знака дроби
            changeSign();
            integer = Math.abs(integer);
        }

        if (numerator < 0) {
            // изменение знака дроби
            changeSign();
            numerator = Math.abs(numerator);
        }

        if (denominator < 0) {
            // изменение знака дроби
            changeSign();
            denominator = Math.abs(denominator);
        }
    }

    // Сокращение дроби
    private void reductionFrac() {
        // определение НОД для числителя и знаменателя
        int gcd = Arithmetic.defineGCD(numerator, denominator);
        // вычисление числителя
        numerator = numerator / gcd;
        // вычисление знаменателя
        denominator = denominator / gcd;
        // вычисление целой части и числителя числа, если числитель больше знаменателя
        if (numerator > denominator) {
            integer += numerator / denominator;
            numerator %= denominator;
        }
    }


    // ГЕТТЕРЫ
    // Получение вводных данных
    public String getInitial() {
        return initial;
    }

    // Получение целой части числа (без знака)
    public int getAbsInteger() {
        return integer;
    }

    // Получение целой части числа (со знаком)
    public int getInteger() {
        return integer * getSignMultiplier();
    }

    // Получение числителя
    public int getNumerator() {
        return numerator;
    }

    // Получение полной формы числителя (со знаком)
    public int getFullNumerator() {
        return (integer * denominator + numerator) * getSignMultiplier();
    }

    // Получение знаменателя
    public int getDenominator() {
        return denominator;
    }

    // Определение отрицательности числа
    public boolean isNegative() {
        return isNegative;
    }

    // Определение положительности числа
    public boolean isPositive() {
        return !isNegative;
    }

    // Получение дробной части
    public String getShortFrac() {
        return (numerator == 0) ? "" : (numerator + "/" + denominator);
    }

    // Получение обыкновенной формы дроби
    public String getOrdinaryFrac() {
        return (getFullNumerator() == 0) ? "0" : (getFullNumerator() + "/" + denominator);
    }

    // Получение смешанной формы дроби
    public String getMixedFrac() {
        return (integer == 0) ? (getSign() + getShortFrac()) :
                                (getInteger() + " " + getShortFrac());
    }

    // Получение десятичной формы дроби
    public double getDecimalFrac() {
        return (integer + (double)numerator / denominator) * getSignMultiplier();
    }


    // СЕТТЕРЫ
    // Установка целой части
    public void setInteger(int integer) {
        // установка целой части
        this.integer = integer;
        // унификация знака
        bringSign();
    }

    // Установка числителя
    public void setNumerator(int numerator) {
        // установка числителя
        this.numerator = numerator;
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Установка знаменателя
    public void setDenominator(int denominator) {
        // исключение попыток сохранение знаменателя со значением 0
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель дроби не может быть равен нулю!");
        }
        // установка знаменателя
        this.denominator = denominator;
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Приведение дроби к определённому знаменателю
    public void reducingToDenominator(int denominator) {
        // исключение попыток сохранение знаменателя со значением 0
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель дроби не может быть равен нулю!");
        }
        // приведение дроби к обыкновенной форме
        numerator = getFullNumerator();
        integer = 0;
        isNegative = false;
        // установка знаменателя
        this.denominator = denominator;
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Изменение знака дроби
    public void changeSign() {
        isNegative = !isNegative;
    }

    // Установка отрицательной дроби
    public void setNegative() {
        isNegative = true;
    }

    // Установка положительной дроби
    public void setPositive() {
        isNegative = false;
    }


    // АРИФМЕТИЧЕСКИЕ ОПЕРАЦИИ ДРОБИ
    // Сложение с другой дробью
    public void addition(Fraction frac) {
        // изменение вводных данных
        initial = "(" + initial + ") + (" + frac.getInitial() + ")";
        // вычисление числителя текущей дроби
        numerator = this.getFullNumerator() * frac.getDenominator() +
                    frac.getFullNumerator() * denominator;
        // обнуление целой части дроби
        integer = 0;
        // удаление знака дроби
        isNegative = false;
        // вычисление знаменателя текущей дроби
        denominator *= frac.getDenominator();
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Вычитание другой дроби
    public void subtraction(Fraction frac) {
        // изменение вводных данных
        initial = "(" + initial + ") - (" + frac.getInitial() + ")";
        // вычисление числителя текущей дроби
        numerator = this.getFullNumerator() * frac.getDenominator() -
                    frac.getFullNumerator() * denominator;
        // обнуление целой части дроби
        integer = 0;
        // удаление знака дроби
        isNegative = false;
        // вычисление знаменателя текущей дроби
        denominator *= frac.getDenominator();
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Умножение с другой дробью
    public void multiplication(Fraction frac) {
        // изменение вводных данных
        initial = "(" + initial + ") * (" + frac.getInitial() + ")";
        // вычисление числителя текущей дроби
        numerator = this.getFullNumerator() * frac.getFullNumerator();
        // обнуление целой части дроби
        integer = 0;
        // удаление знака дроби
        isNegative = false;
        // вычисление знаменателя текущей дроби
        denominator *= frac.getDenominator();
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }

    // Деление на другую дробь
    public void division(Fraction frac) {
        // исключение попыток сохранение знаменателя со значением 0
        if (frac.getFullNumerator() == 0) {
            throw new ArithmeticException("Числитель второй дроби не может быть равен нулю!");
        }
        // изменение вводных данных
        initial = "(" + initial + ") / (" + frac.getInitial() + ")";
        // вычисление числителя текущей дроби
        numerator = this.getFullNumerator() * frac.getDenominator();
        // обнуление целой части дроби
        integer = 0;
        // удаление знака дроби
        isNegative = false;
        // вычисление знаменателя текущей дроби
        denominator *= frac.getFullNumerator();
        // унификация знака
        bringSign();
        // сокращение дроби
        reductionFrac();
    }
}