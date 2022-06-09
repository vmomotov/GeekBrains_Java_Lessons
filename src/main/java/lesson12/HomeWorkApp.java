package lesson12;

import java.util.Arrays;

public class HomeWorkApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        calculateWithOneThread();
        try {
            calculateParallel();
        } catch (InterruptedException e) {
            System.out.println("calculateParallel failed. Interrupted exception happened");
        }
    }

    public static float calculateOneElement(float n, int i) {
        return (float)(n * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                Math.cos(0.4f + i / 2));
    }
    public static void calculateWithOneThread() {

        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < SIZE; i++) {
            arr[i] = calculateOneElement(arr[i], i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(String.format("Calculate one thread time: %d", endTime - startTime));

    }

    public static void calculateParallel() throws  InterruptedException {

        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread( () -> {
            for(int i = 0; i < HALF; i++) {
                arr[i] = calculateOneElement(arr[i], i);
            }
        });

        Thread thread2 = new Thread( () -> {
            for(int i = HALF; i < SIZE; i++) {
                arr[i] = calculateOneElement(arr[i], i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("Calculate parallel time: %d", endTime - startTime));

    }
}

