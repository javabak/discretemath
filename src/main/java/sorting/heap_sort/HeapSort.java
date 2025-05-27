package sorting.heap_sort;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение длины массива
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Чтение элементов массива
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Сортировка
        heapSort(arr);

        // Вывод результата
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }

    // Основной метод сортировки кучей
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // Метод для поддержания свойства кучи
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;      // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}