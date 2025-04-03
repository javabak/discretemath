package topology_dijkstra.topological_sort;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> adjacencyList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int neighbor = Integer.parseInt(parts[j]);
                adjacencyList.get(i).add(neighbor);
                inDegree[neighbor]++;
            }
        }

        List<Integer> result = kahnSort(adjacencyList, inDegree, n);

        if (result.size() != n) {
            System.out.println("-1");
        } else {
            for (int vertex : result) {
                System.out.print(vertex + " ");
            }
        }
    }

    public static List<Integer> kahnSort(List<List<Integer>> adjacencyList, int[] inDegree, int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            result.add(currentVertex);

            for (int neighbor : adjacencyList.get(currentVertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}