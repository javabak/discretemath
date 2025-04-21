package one_dimensional_dynamics;

import java.util.Scanner;

public class MaximumPathSum {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();
            }

            int[] dp = new int[N];
            dp[0] = a[0];
            dp[1] = a[0] + a[1];

            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(dp[i - 1] + a[i], dp[i - 2] + a[i]);
            }

            System.out.println(dp[N - 1]);
        }
    }