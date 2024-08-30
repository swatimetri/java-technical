import java.util.Scanner;
public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        printCalendar(year, month);
        sc.close();
    }

    public static void printCalendar(int year, int month) {
        int daysInMonth = getDaysInMonth(year, month);
        int dayOfWeek = getDayOfWeek(year, month, 1);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < dayOfWeek - 1; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d ", i);
            if ((i + dayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
    

        public static int getDayOfWeek(int year, int month, int day) {
            int totalDays = 0;
            for (int y = 1900; y < year; y++) {
                if (isLeapYear(y)) {
                    totalDays += 366;
                } else {
                    totalDays += 365;
                }
            }
            int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (isLeapYear(year)) {
                monthDays[1] = 29;
            }
            for (int m = 1; m < month; m++) {
                totalDays += monthDays[m - 1];
            }
            totalDays += day - 1;
            int referenceDay = 2; // January 1, 1900 is a Monday
            int dayOfWeek = (totalDays + referenceDay) % 7;
            return dayOfWeek;
        }
        
        
        

    public static int getDaysInMonth(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}