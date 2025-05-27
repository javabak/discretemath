package two_dimensional_dynamics;

import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение входных данных
        int N = scanner.nextInt(); // Количество предметов
        int W = scanner.nextInt(); // Вместимость рюкзака

        int[] weights = new int[N + 1]; // Веса предметов
        int[] values = new int[N + 1];  // Ценности предметов

        // Чтение весов и ценностей
        for (int i = 1; i <= N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                // Не берем текущий предмет
                dp[i][w] = dp[i - 1][w];

                // Если можем взять текущий предмет
                if (w >= weights[i]) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][W]);

        scanner.close();
    }
}