package two_dimensional_dynamics;

import java.util.*;

public class LCS {
    static String A, B;
    static int[][] dp;
    static String[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextLine();
        B = scanner.nextLine();
        int n = A.length(), m = B.length();
        dp = new int[n + 1][m + 1];
        memo = new String[n + 1][m + 1];

        // Заполнение dp-таблицы
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        System.out.println(recover(n, m));
    }

    // Восстановление лексикографически минимальной LCS
    static String recover(int i, int j) {
        if (i == 0 || j == 0) return "";
        if (memo[i][j] != null) return memo[i][j];

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            memo[i][j] = recover(i - 1, j - 1) + A.charAt(i - 1);
        } else {
            String res1 = "", res2 = "";
            if (dp[i - 1][j] > dp[i][j - 1]) {
                res1 = recover(i - 1, j);
                memo[i][j] = res1;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                res2 = recover(i, j - 1);
                memo[i][j] = res2;
            } else { // равны
                res1 = recover(i - 1, j);
                res2 = recover(i, j - 1);
                memo[i][j] = res1.compareTo(res2) < 0 ? res1 : res2;
            }
        }
        return memo[i][j];
    }
}
