import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

       Scanner scanner= new Scanner(System.in);

        System.out.print("Principal: ");
        int amount = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest =  annualInterest / MONTHS_IN_YEAR / PERCENT ;

        System.out.print("Period(years): ");
        byte years = scanner.nextByte();
        int numbersOfPayments = years * MONTHS_IN_YEAR;

        System.out.print("Mortgage: ");
        double mortgage = amount
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments))
                / (Math.pow(1 + monthlyInterest, numbersOfPayments) -1)
                ;
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print(result);


    }
}