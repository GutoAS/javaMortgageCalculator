import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int amount = 0;
        float monthlyInterest = 0;
        int numbersOfPayments = 0;

       Scanner scanner= new Scanner(System.in);

        while (true) {
            System.out.print("Principal (1K - 1M): ");
            amount = scanner.nextInt();
            if (amount >= 1000 && amount <= 1_000_000)
                break;
            System.out.println("Enter a number Between (1,000 and 1,000,000)");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30){
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break;
            }
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        while (true) {
            System.out.print("Period(years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30){
                numbersOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
                System.out.println("Enter a  value between 1 and 30");

        }

            System.out.print("Mortgage: ");
            double mortgage = amount
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments))
                    / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1);
            String result = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.print(result);


    }
}