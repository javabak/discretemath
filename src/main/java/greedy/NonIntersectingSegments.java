package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NonIntersectingSegments {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            Segment[] segments = new Segment[N];

            for (int i = 0; i < N; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                segments[i] = new Segment(l, r);
            }

            // Сортировка по правому концу отрезка
            Arrays.sort(segments, Comparator.comparingInt(seg -> seg.r));

            int count = 0;
            int lastEnd = Integer.MIN_VALUE;

            for (Segment seg : segments) {
                if (seg.l >= lastEnd) {
                    count++;
                    lastEnd = seg.r;
                }
            }

            System.out.println(count);
        }

        static class Segment {
            int l, r;

            Segment(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
    }
