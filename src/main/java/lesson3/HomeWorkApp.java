package lesson3;

import java.util.Arrays;
import java.util.Random;


public class HomeWorkApp {

    static final int ARRAY_SIZE = 10;

    public static void main(String args[]) {
        changeZeroOneArray();
        fillArrayHundred();
        multiplySomeElementsByTwo();
        fillDiagonalElements();
        System.out.println(Arrays.toString(getArray(5, 42)));
        findMinMaxElements();

        int[] arrForCheckBalance = {1, 1, 1, 2, 1};
        checkBalance(arrForCheckBalance);
    }

    // 1
    private static void changeZeroOneArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else { // assuming that arr[i] == 1
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 2
    private static void fillArrayHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 3
    private static void multiplySomeElementsByTwo() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 4
    private static void fillDiagonalElements() {
        int[][] arr = new int[ARRAY_SIZE][ARRAY_SIZE];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i == j) || (i + j == ARRAY_SIZE - 1)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.printf(Integer.toString(arr[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // 5
    private static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    // 6
    private static void findMinMaxElements() {
        int[] arr = new int[ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        int minElement = arr[0];
        int maxElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        System.out.println("Minimal element : " + minElement);
        System.out.println("Maximal element : " + maxElement);
        System.out.println("From array :\n" + Arrays.toString(arr));
    }

    // 7
    private static boolean checkBalance(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j ++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }
}
