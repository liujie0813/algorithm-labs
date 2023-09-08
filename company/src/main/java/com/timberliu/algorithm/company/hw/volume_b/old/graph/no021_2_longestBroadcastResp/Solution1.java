package com.timberliu.algorithm.company.hw.volume_b.old.graph.no021_2_longestBroadcastResp;

import java.util.*;

/**
 * 最长广播响应
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int longestBroadcastResp(int n, int t, int[][] relations, int src) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;

            List<Integer> list1 = graph.computeIfAbsent(u, (val) -> new ArrayList<>());
            list1.add(v);
            List<Integer> list2 = graph.computeIfAbsent(v, (val) -> new ArrayList<>());
            list2.add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src - 1, 0});
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            for (Integer v : graph.get(u)) {
                int newDist = dist[u] + 1;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{ v, newDist });
                }
            }
        }

        int max = 0;
        for (int d : dist) {
            max = Math.max(max, d);
        }
        return max * 2;
    }

    /**
     * 5 7
     * 1 4
     * 2 1
     * 2 3
     * 2 4
     * 3 4
     * 3 5
     * 4 5
     * 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        int r = scanner.nextInt();

        int res = longestBroadcastResp(n, t, arr, r);
        System.out.println(res);
    }

}
