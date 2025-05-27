package two_dimensional_dynamics;

import java.util.Scanner;

public class TwoKnapsacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // количество предметов
        int W1 = scanner.nextInt(); // вместимость первого рюкзака
        int W2 = scanner.nextInt(); // вместимость второго рюкзака

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[W1 + 1][W2 + 1];

        for (int i = 0; i < N; i++) {
            int wi = weights[i];
            int vi = values[i];

            // Обратный проход, чтобы не использовать предмет более одного раза
            for (int w1 = W1; w1 >= 0; w1--) {
                for (int w2 = W2; w2 >= 0; w2--) {
                    // Взять предмет в первый рюкзак, если влезает
                    if (w1 >= wi) {
                        dp[w1][w2] = Math.max(dp[w1][w2], dp[w1 - wi][w2] + vi);
                    }

                    // Взять предмет во второй рюкзак, если влезает
                    if (w2 >= wi) {
                        dp[w1][w2] = Math.max(dp[w1][w2], dp[w1][w2 - wi] + vi);
                    }
                }
            }
        }

        System.out.println(dp[W1][W2]);
    }
}
