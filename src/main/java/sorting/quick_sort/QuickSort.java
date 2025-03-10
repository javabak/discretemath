package sorting.quick_sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class QuickSort {

    public static void quickSortAndReadFromConsole() {
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

        // Быстрая сортировка
        quickSort(array, 0, array.length - 1);

        // Вывод отсортированного массива
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();

        scanner.close();
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        swap(array, pivotIndex, high); // Перемещаем опорный элемент в конец
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        quickSortAndReadFromConsole();
    }
}
