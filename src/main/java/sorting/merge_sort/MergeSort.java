package sorting.merge_sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение N
        int n = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Чтение массива
        String[] arrayElements = scanner.nextLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(arrayElements[i]);
        }

        // Сортировка массива
        mergeSort(array);

        // Вывод отсортированного массива
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();

        scanner.close();

    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, tempArray, left, mid);
            mergeSort(array, tempArray, mid + 1, right);
            merge(array, tempArray, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k++] = tempArray[i++];
            } else {
                array[k++] = tempArray[j++];
            }
        }

        while (i <= mid) {
            array[k++] = tempArray[i++];
        }
    }
}
