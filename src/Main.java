import Classes.Arithmetic;
import Classes.Fraction;

public class Main {
    private static void PrintFraction(Fraction frac) {
        StringBuilder result = new StringBuilder();
        result.append("ВВОД: \"" + frac.getInitial() + "\"");
        result.append("\nОбыкновенная форма дроби: " + frac.getOrdinaryFrac());
        result.append("\nСмешанная форма дроби: " + frac.getMixedFrac());
        result.append("\nДесятичная форма дроби: " + frac.getDecimalFrac() + "\n");
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("\nC O N S T R U C T O R S :\n");

        Fraction frac1 = new Fraction(-25);
        PrintFraction(frac1);

        Fraction frac2 = new Fraction(-13, -20);
        PrintFraction(frac2);

        Fraction frac3 = new Fraction(55, -17);
        PrintFraction(frac3);

        Fraction frac4 = new Fraction(-5, -17, -95);
        PrintFraction(frac4);

        Fraction frac5 = new Fraction(2, 13, -5);
        PrintFraction(frac5);

        Fraction frac6 = new Fraction(-0.0099);
        PrintFraction(frac6);

        Fraction frac7 = new Fraction(-17.014);
        PrintFraction(frac7);

        Fraction frac8 = new Fraction("37");
        PrintFraction(frac8);

        Fraction frac9 = new Fraction("-78.015");
        PrintFraction(frac9);

        Fraction frac10 = new Fraction("791/-17");
        PrintFraction(frac10);

        Fraction frac11 = new Fraction("-12 3/-14");
        PrintFraction(frac11);

        Fraction frac12 = new Fraction("-125 -60/-11");
        PrintFraction(frac12);

        System.out.println("\nA R I T H M E T I C   O P E R A T I O N S :\n");

        // addition
        Fraction frac13 = Arithmetic.addition(frac1, frac2);
        PrintFraction(frac13);

        frac3.addition(frac4);
        PrintFraction(frac3);

        // subtraction
        Fraction frac14 = Arithmetic.subtraction(frac5, frac6);
        PrintFraction(frac14);

        frac7.subtraction(frac8);
        PrintFraction(frac7);

        // multiplication
        Fraction frac15 = Arithmetic.multiplication(frac9, frac10);
        PrintFraction(frac15);

        frac11.multiplication(frac12);
        PrintFraction(frac11);

        // division
        Fraction frac16 = Arithmetic.division(frac13, frac14);
        PrintFraction(frac16);

        frac15.division(frac16);
        PrintFraction(frac15);
    }
}
