package homework10;

import java.util.Arrays;
import java.util.Random;
import static java.util.Arrays.sort;
/*
5**) Реализовать 3 сложные сортировки массива
Quick, Heap, Merge
**/

public class Dz5 {

    public static final Random RANDOM = new Random();
    private static final int MAX_LENGHT_ARRAY = 100000;

    public static void main(String[] args) {
        int[] arr = new int[MAX_LENGHT_ARRAY];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));

        System.out.println("mergeSort");
        long time = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        timeWork(time, "Time: ");

        System.out.println("heapSort");
        long time2 = System.currentTimeMillis();
        heapSort(arr);
        timeWork(time2, "Time2: ");

        System.out.println("quickSort");
        long time3 = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        timeWork(time3, "Time3: ");

    }

    private static void timeWork(long time, String s) {
        time = System.currentTimeMillis() - time;
        System.out.println(s + time / 1000.0);
    }

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    private static int[] mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }

    public static int[] heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    /**/
    public static int[] quickSort(int[] arr, int low, int high) {
//            if (arr.length == 0){
//                break;
//            }
//            if (low >= high){
//                return;
//            }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
        return arr;
    }
}
