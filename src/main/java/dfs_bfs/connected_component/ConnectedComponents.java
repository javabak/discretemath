package dfs_bfs.connected_component;

import java.util.*;

public class ConnectedComponents {

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

        int components = countConnectedComponents(adjacencyList, n);
        System.out.println(components);
    }

    public static int countConnectedComponents(List<List<Integer>> adjacencyList, int n) {
        boolean[] visited = new boolean[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(adjacencyList, visited, i);
                count++;
            }
        }

        return count;
    }

    public static void bfs(List<List<Integer>> adjacencyList, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}