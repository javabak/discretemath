package binary_search.find_peak;

import java.util.Scanner;

public class FindPeak {

    public static int findPeakIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // Ищем пик в правой половине
            } else {
                right = mid; // Ищем пик в левой половине или нашли пик
            }
        }

        return left; // left и right указывают на пик
    }

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

        // Поиск индекса пика
        int peakIndex = findPeakIndex(array);

        // Вывод результата
        System.out.println(peakIndex);

        scanner.close();
    }
}