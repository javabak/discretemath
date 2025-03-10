package binary_search.nearest_element;

import java.util.Scanner;

public class NearestElement {
    public static int nearestElement(int[] array, int x) {
        int n = array.length;

        if (x <= array[0]) {
            return 0;
        }
        if (x >= array[n - 1]) {
            return n - 1;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (Math.abs(array[left] - x) < Math.abs(array[right] - x)) {
            return left;
        } else if (Math.abs(array[left] - x) > Math.abs(array[right] - x)) {
            return right;
        } else {
            return right;
        }
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
            int result = nearestElement(array, x);
            System.out.println(result);
        } else {
            System.err.println("Error: Array length does not match N");
            System.exit(1);
        }

        scanner.close();
    }
}