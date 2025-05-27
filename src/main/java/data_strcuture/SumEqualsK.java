package data_strcuture;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumEqualsK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        if (hasPairWithSum(arr, k)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean hasPairWithSum(int[] arr, int k) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;
            if (seenNumbers.contains(complement)) {
                return true; // Найдена пара, сумма которой равна k
            }
            seenNumbers.add(num); // Добавляем текущее число в множество
        }

        return false; // Пара не найдена
    }
}