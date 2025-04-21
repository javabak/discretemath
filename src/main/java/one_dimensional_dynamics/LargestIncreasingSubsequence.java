package one_dimensional_dynamics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LargestIncreasingSubsequence {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();
            }

            List<Integer> lis = new ArrayList<>();

            for (int num : a) {
                int idx = Collections.binarySearch(lis, num);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                if (idx == lis.size()) {
                    lis.add(num); // добавляем новый конец
                } else {
                    lis.set(idx, num); // заменяем текущий конец
                }
            }

            System.out.println(lis.size());
        }
    }
