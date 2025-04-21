package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PurchasingItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(prices);

        int count = 0;
        long currentCost = 0;
        for (int price : prices) {
            if (currentCost + price <= k) {
                currentCost += price;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}