package dfs_bfs.dfs;

import java.util.*;

public class DFS {

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

        List<Integer> dfsResult = dfs(adjacencyList, n);
        for (int vertex : dfsResult) {
            System.out.print(vertex + " ");
        }
    }

    public static List<Integer> dfs(List<List<Integer>> adjacencyList, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();

        int startVertex = 1;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                result.add(currentVertex);

                // Добавляем соседей в обратном порядке, чтобы обойти их в нужном порядке
                List<Integer> neighbors = adjacencyList.get(currentVertex);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }
}