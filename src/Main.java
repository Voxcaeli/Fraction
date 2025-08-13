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
        System.out.println("\nD I V I S I O N :\n");

        Fraction frac1 = new Fraction("-10 20/30");
        PrintFraction(frac1);

        Fraction frac2 = new Fraction(15, 13, -11);
        PrintFraction(frac2);

        Fraction frac3 = Arithmetic.division(frac1, frac2);
        PrintFraction(frac3);
    }
}