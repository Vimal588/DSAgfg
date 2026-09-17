import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {

        // Adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Original direction -> cost 0
            graph[u].add(new int[]{v, 0});

            // Reverse direction -> cost 1
            graph[v].add(new int[]{u, 1});
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 0-1 BFS
        Deque<Integer> deque = new ArrayDeque<>();

        dist[src] = 0;
        deque.addFirst(src);

        while (!deque.isEmpty()) {

            int u = deque.pollFirst();

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (dist[u] + cost < dist[v]) {

                    dist[v] = dist[u] + cost;

                    // Cost 0 -> front
                    if (cost == 0) {
                        deque.addFirst(v);
                    }
                    // Cost 1 -> back
                    else {
                        deque.addLast(v);
                    }
                }
            }
        }

        // No path possible
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}