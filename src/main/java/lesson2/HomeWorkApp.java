package lesson2;

public class HomeWorkApp {

    public static void main(String args[]) {
        checkSum(10, 7);
        printIsPositive(25);
        isNegative(-12);
        printSeveralTimes("Repeated string", 5);
        isLeapYear(2022);
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printIsPositive(int number) {
        if (number >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printSeveralTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        if ( (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0 ) ) {
            return true;
        } else {
            return false;
        }
    }

}
