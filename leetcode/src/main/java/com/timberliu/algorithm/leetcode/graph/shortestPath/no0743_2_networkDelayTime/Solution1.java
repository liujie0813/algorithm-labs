package com.timberliu.algorithm.leetcode.graph.shortestPath.no0743_2_networkDelayTime;

import java.util.*;

/**
 * 743. 网络延迟时间
 *
 * dijkstra：单源最短路径，贪心
 *
 * 将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。
 *
 * 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」
 *
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution1 {

    private int INF = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接表
        List<List<int[]>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            lists.get(x).add(new int[]{y, time[2]});
        }

        int[] res = new int[n];
        Arrays.fill(res, INF);
        res[k - 1] = 0;

        boolean[] visited = new boolean[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> res[a]));
        pq.offer(k - 1);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            // 节点访问过，则跳过
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (int[] e : lists.get(cur)) {
                int next = e[0];
                int cost = e[1];
                if (visited[next]) {
                    continue;
                }
                // 更新最短距离
                res[next] = Math.min(res[next], res[cur] + cost);
                pq.offer(next);
            }
        }

        int max = Arrays.stream(res).max().getAsInt();
        return max == INF ? -1 : max;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.networkDelayTime(new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        }, 4, 2);
        System.out.println(res);

    }

}
