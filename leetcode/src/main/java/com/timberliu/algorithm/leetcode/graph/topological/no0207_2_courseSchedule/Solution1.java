package com.timberliu.algorithm.leetcode.graph.topological.no0207_2_courseSchedule;

import java.util.*;

/**
 * 207. 课程表
 *
 * 拓扑排序
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        Map<Integer, List<Integer>> edges = new HashMap<>();
        // 统计入度
        int[] inDegree = new int[numCourses];
        for (int[] r : prerequisites) {
            List<Integer> list = edges.computeIfAbsent(r[1], (val) -> new ArrayList<>());
            list.add(r[0]);
            inDegree[r[0]]++;
        }
        // 先把入度为 0 的边 添加到队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            visited++;
            List<Integer> next = edges.get(top);
            if (next == null) {
                continue;
            }
            // 遍历当前节点的邻接节点
            for (int a : next) {
                // 入度--
                inDegree[a]--;
                // 入度为 0 时添加到队列
                if (inDegree[a] == 0) {
                    queue.offer(a);
                }
            }
        }
        // 不需要输出拓扑排序的结果
        // 只需要判断是否遍历了所有节点即可
        return visited == numCourses;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean res1 = solution1.canFinish(2, new int[][]{{1, 0}});
        System.out.println(res1);
    }

}
