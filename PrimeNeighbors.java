import java.util.Scanner;

public class PrimeNeighbors {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true; 
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;                                                                                                                                                                                                 
    }

    
    public static int findPreviousPrime(int number) {
        int previous = number - 1;
        while (previous >= 2) {
            if (isPrime(previous)) return previous;
            previous--;
        }
        return -1; 
    }

    
    public static int findNextPrime(int number) {
        int next = number + 1;
        while (true) {
            if (isPrime(next)) return next;
            next++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a prime number: ");
        int primeNumber = scanner.nextInt();

       
        scanner.close();

        if (isPrime(primeNumber)) {
            int previousPrime = findPreviousPrime(primeNumber);
            int nextPrime = findNextPrime(primeNumber);

            System.out.println("Given prime number: " + primeNumber);
            System.out.println("Previous prime number: " + previousPrime);
            System.out.println("Next prime number: " + nextPrime);
        } else {
            System.out.println(primeNumber + " is not a prime number.");
        }
    }
}
