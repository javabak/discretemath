package data_strcuture;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        List<Integer> result = findSlidingWindowMaximum(arr, k);

        // Вывод результатов
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static List<Integer> findSlidingWindowMaximum(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return result; // Возвращаем пустой список для некорректных входных данных
        }


        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        // Обработка оставшихся элементов
        for (int i = k; i < arr.length; i++) {
            // Максимум текущего окна - это элемент по индексу в начале Deque
            result.add(arr[dq.peekFirst()]);

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        result.add(arr[dq.peekFirst()]);

        return result;
    }
}