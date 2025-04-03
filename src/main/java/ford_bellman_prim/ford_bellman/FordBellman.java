package ford_bellman_prim.ford_bellman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Graph {
    private int V;
    private List<int[]> edges;

    public Graph(int vertices) {
        this.V = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new int[]{u, v, w});
    }

    public Result BellmanFord(int src, int dest) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int[] parent = new int[V + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                return new Result(-1, null); // Обнаружен отрицательный цикл
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return new Result(-1, null); // Путь не найден
        }

        List<Integer> path = new ArrayList<>();
        int curr = dest;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        java.util.Collections.reverse(path);

        return new Result(dist[dest], path);
    }
}

class Result {
    int distance;
    List<Integer> path;

    public Result(int distance, List<Integer> path) {
        this.distance = distance;
        this.path = path;
    }
}

public class FordBellman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(u, v, w);
        }

        Result result = graph.BellmanFord(A, B);

        if (result.distance == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result.distance);
            for (int node : result.path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}