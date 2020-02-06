package homework10;

import java.util.Arrays;
import java.util.Random;

/*
4*) Реализовать 3 сортировки массива. Сравнить их по быстродействию:
    Bubble
    Insert
    Select
 */

public class Dz4 {
    public static final Random RANDOM = new Random();
    private static final int MAX_LENGHT_ARRAY = 100000;

    public static void main(String[] args) {
        int[] arr = new int[MAX_LENGHT_ARRAY];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));

        System.out.println("bubbleSort");
        long time = System.currentTimeMillis();
        bubbleSort(arr);
        timeWork(time, "Time: ");

        System.out.println("insterionSort");
        long time2 = System.currentTimeMillis();
        insterionSort(arr);
        timeWork(time2, "Time2: ");

        System.out.println("selectionSort");
        long time3 = System.currentTimeMillis();
        selectionSort(arr);
        timeWork(time3, "Time3: ");

    }

    private static void timeWork(long time, String s) {
        time = System.currentTimeMillis() - time;
        System.out.println(s + time / 1000.0);
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        return arr;
    }

    private static int[] insterionSort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private static int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
