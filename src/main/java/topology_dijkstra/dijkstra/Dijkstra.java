package topology_dijkstra.dijkstra;

import java.util.*;

class Dijkstra {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        public int compareTo(Node other) {
            if (this.distance != other.distance) {
                return Integer.compare(this.distance, other.distance);
            }
            return Integer.compare(this.vertex, other.vertex); // Приоритет меньшим индексам
        }
    }

    public static List<Integer> dijkstra(List<List<Edge>> graph, int start, int end, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            if (current.distance > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to, w = edge.weight;
                if (dist[u] + w < dist[v] || (dist[u] + w == dist[v] && u < prev[v])) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        if (dist[end] == INF) return Collections.singletonList(-1);

        List<Integer> path = new ArrayList<>();
        for (int v = end; v != -1; v = prev[v]) {
            path.add(v + 1);
        }
        Collections.reverse(path);
        path.add(0, dist[end]);
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), start = sc.nextInt() - 1, end = sc.nextInt() - 1;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt() - 1, w = sc.nextInt();
                graph.get(i).add(new Edge(v, w));
            }
        }
        sc.close();

        List<Integer> result = dijkstra(graph, start, end, n);

        if (result.size() == 1 && result.get(0) == -1) {
            System.out.println("-1");
        } else {
            System.out.print(result.get(0) + "\n");
            for (int i = 1; i < result.size(); i++) {
                System.out.print(result.get(i) + (i == result.size() - 1 ? "\n" : " "));
            }
        }
    }
}
