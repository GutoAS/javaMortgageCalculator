import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int amount = (int) readNumber("Principal (1K - 1M): ",1_000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ",1, 30);
        byte years = (byte) readNumber("Period(years): ",1 ,30);

        double mortgage = calculateMortgage(amount, annualInterest , years);

        System.out.print("Mortgage: ");
            String result = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.print(result);
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number Between " + (short)min + " and " + (int)max);
        }

        return value;
    }
    public static double calculateMortgage(
            int amount,
            float annualInterest,
            byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short  numbersOfPayments = (short)( years * MONTHS_IN_YEAR);

        return amount
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments))
                / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1);
    }
}