package ford_bellman_prim.minimum_spanning_tree;

import java.util.*;

class Edge {
    int u, v, weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class MinimumSpanningTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N == 1 && M == 0) {
            System.out.println("0");
            return;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        int mstWeight = prim(N, edges);
        if (mstWeight == -1) {
            System.out.println("-1");
        }
    }

    private static int prim(int N, List<Edge> edges) {
        boolean[] visited = new boolean[N];
        int mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited[0] = true;

        for (Edge edge : edges) {
            if (edge.u == 0 || edge.v == 0) {
                pq.add(edge);
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.u] && !visited[edge.v]) {
                visited[edge.v] = true;
                mstWeight += edge.weight;
                mstEdges.add(edge);

                for (Edge nextEdge : edges) {
                    if ((nextEdge.u == edge.v && !visited[nextEdge.v]) || (nextEdge.v == edge.v && !visited[nextEdge.u])) {
                        pq.add(nextEdge);
                    }
                }
            } else if (visited[edge.v] && !visited[edge.u]) {
                visited[edge.u] = true;
                mstWeight += edge.weight;
                mstEdges.add(edge);

                for (Edge nextEdge : edges) {
                    if ((nextEdge.u == edge.u && !visited[nextEdge.v]) || (nextEdge.v == edge.u && !visited[nextEdge.u])) {
                        pq.add(nextEdge);
                    }
                }
            }
        }

        int connectedVertices = 0;
        for (boolean visitedVertex : visited) {
            if (visitedVertex) {
                connectedVertices++;
            }
        }

        if (connectedVertices != N) {
            return -1; // Возвращаем -1, если граф не связан
        }

        if (mstEdges.size() != N - 1) {
            return -1; // Возвращаем -1, если недостаточно рёбер в МОТ
        }

        System.out.println(mstWeight);

        Collections.sort(mstEdges, (a, b) -> {
            if (a.u != b.u) return a.u - b.u;
            return a.v - b.v;
        });

        for (Edge e : mstEdges) {
            System.out.print((e.u + 1) + " " + (e.v + 1) + " ");
        }
        System.out.println();

        return mstWeight;
    }
}