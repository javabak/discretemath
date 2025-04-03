package topology_dijkstra.shortest_path_bfs;

import java.util.*;

public class ShortestPathBFS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> adjacencyList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int neighbor = Integer.parseInt(parts[j]);
                adjacencyList.get(i).add(neighbor);
            }
        }

        List<Integer> path = bfs(adjacencyList, start, end, n);

        if (path.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.print(path.size() - 1 + "\n");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
        }
    }

    public static List<Integer> bfs(List<List<Integer>> adjacencyList, int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == end) {
                return reconstructPath(parent, end);
            }

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>(); // Путь не найден
    }

    public static List<Integer> reconstructPath(int[] parent, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }

        return path;
    }
}