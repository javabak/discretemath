package one_dimensional_dynamics;

import java.util.Scanner;

public class NumberOfNumberSplits {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();

            // dp[i][j] = количество способов разложить число j, используя числа от 1 до i
            int[][] dp = new int[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (j < i) {
                        dp[i][j] = dp[i - 1][j]; // не берём i
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - i]; // либо не берём i, либо берём
                    }
                }
            }

            System.out.println(dp[N][N]);
        }
    }
