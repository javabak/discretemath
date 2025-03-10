package binary_search.lower_bound;

import java.util.Scanner;

public class LowerBound {

    public static int lowerBound(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Избегаем переполнения
            if (array[mid] >= x) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение N и X из первой строки
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после чтения чисел

        // Чтение массива из второй строки
        String[] arrayElements = scanner.nextLine().split(" ");
        int[] array = new int[n];
        if (arrayElements.length == n) {
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(arrayElements[i]);
            }

            // Вызов основного метода и вывод результата
            int result = lowerBound(array, x);
            System.out.println(result);
        } else {
            System.err.println("Error: Array length does not match N");
            System.exit(1);
        }

        scanner.close();
    }
}