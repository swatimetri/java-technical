import java.util.Scanner;

public class ElectricityBillCalculator {

    private static final double RATE_0_100 = 0.10; // added this rate
    private static final double RATE_101_200 = 0.15;
    private static final double RATE_201_300 = 0.20;
    private static final double RATE_ABOVE_300 = 0.25;
    private static final double SERVICE_CHARGE = 5.00;
    private static final double TAX_RATE = 0.12; // 12% tax rate

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of units consumed: ");
        double units = scanner.nextDouble();

        if (units < 0) {
            System.out.println("Invalid input: Units cannot be negative.");
            scanner.close();
            return;
        }

        double billBeforeTax = calculateBill(units);
        double tax = billBeforeTax * TAX_RATE;
        double totalBill = billBeforeTax + tax;

        System.out.printf("Total Units Consumed: %.2f units\n", units);
        System.out.printf("Service Charge: $%.2f\n", SERVICE_CHARGE);
        System.out.printf("Bill Before Tax: $%.2f\n", billBeforeTax);
        System.out.printf("Tax (%.0f%%): $%.2f\n", TAX_RATE * 100, tax);
        System.out.printf("Total Electricity Bill: $%.2f\n", totalBill);

        scanner.close();
    }

    private static double calculateBill(double units) {
        double bill = 0.0;

        if (units <= 100) {
            bill = units * RATE_0_100;
        } else if (units <= 200) {
            bill = (100 * RATE_0_100) + ((units - 100) * RATE_101_200);
        } else if (units <= 300) {
            bill = (100 * RATE_0_100) + (100 * RATE_101_200) + ((units - 200) * RATE_201_300);
        } else {
            bill = (100 * RATE_0_100) + (100 * RATE_101_200) + (100 * RATE_201_300) + ((units - 300) * RATE_ABOVE_300);
        }

        bill += SERVICE_CHARGE;

        return bill;
    }
}