package greedy;

import java.util.*;

public class TaskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Task[] tasks = new Task[N];
        int maxDeadline = 0;

        for (int i = 0; i < N; i++) {
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            tasks[i] = new Task(d, w);
            maxDeadline = Math.max(maxDeadline, d);
        }

        // Сортируем задачи по дедлайну
        Arrays.sort(tasks, (a, b) -> {
            if (a.deadline == b.deadline)
                return b.reward - a.reward; // больше награда — выше приоритет
            return a.deadline - b.deadline;
        });

        // Мин-куча для хранения текущих выбранных задач по награде
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Task task : tasks) {
            if (pq.size() < task.deadline) {
                pq.offer(task.reward); // можно добавить задачу
            } else if (!pq.isEmpty() && pq.peek() < task.reward) {
                pq.poll(); // убираем наименее выгодную
                pq.offer(task.reward);
            }
        }

        long totalReward = 0;
        while (!pq.isEmpty()) {
            totalReward += pq.poll();
        }

        System.out.println(totalReward);
    }

    static class Task {
        int deadline;
        int reward;

        Task(int deadline, int reward) {
            this.deadline = deadline;
            this.reward = reward;
        }
    }
}
