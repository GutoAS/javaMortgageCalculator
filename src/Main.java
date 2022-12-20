import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);
        System.out.print("Principal: ");
        float amount = scanner.nextFloat();
        System.out.print("Annual Interest Rate: ");
        float interestRate = scanner.nextFloat();
        double r = ( ( (double) interestRate / (double) 100) / (double)  12) ;
        System.out.print("Period(years): ");
        byte year = scanner.nextByte();
        double expo = Math.pow((1 + r), year);
        System.out.println("Mortgage: ");
        double mortgage = amount *( (r * expo) / (expo - 1) );
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(result);


    }
}