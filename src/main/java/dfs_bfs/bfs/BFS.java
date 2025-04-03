package dfs_bfs.bfs;

import java.util.*;

public class BFS {

    public static List<Integer> bfs(List<List<Integer>> adjacencyList, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        int startVertex = 1;
        visited[startVertex] = true;
        queue.add(startVertex);
        result.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Пропускаем символ новой строки

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

        List<Integer> bfsResult = bfs(adjacencyList, n);
        for (int vertex : bfsResult) {
            System.out.print(vertex + " ");
        }
    }
}
