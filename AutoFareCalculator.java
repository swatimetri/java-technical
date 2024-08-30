import java.util.Scanner;
public class AutoFareCalculator {
    
    private static final int BASE_FARE = 50;       
    private static final int PER_KM_RATE = 20;     
    private static final int PER_MINUTE_RATE = 1;  

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance traveled (in kilometers): ");
        int distance = sc.nextInt();

        System.out.print("Enter the time taken (in minutes): ");
        int time = sc.nextInt();
        double fare = calculateFare(distance, time);
        System.out.printf("The total fare for your ride is: %.2f\n", fare);
        sc.close();
    }

    
    private static double calculateFare(double distance, double time) {
        
        double fare = BASE_FARE + (PER_KM_RATE * distance) + (PER_MINUTE_RATE * time);
        return fare;
    }
}
