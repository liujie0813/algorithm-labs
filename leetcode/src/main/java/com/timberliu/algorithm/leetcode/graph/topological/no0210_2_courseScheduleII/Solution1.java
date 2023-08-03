package com.timberliu.algorithm.leetcode.graph.topological.no0210_2_courseScheduleII;

import java.util.*;

/**
 * 207. 课程表 II
 *
 * 拓扑排序
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution1 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res[index++] = top;
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
        // 需要输出拓扑排序的结果
        return index == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] res1 = solution1.findOrder(4, new int[][]{
                {1,0},{2,0}, {3,1}, {3,2}
        });
        System.out.println(Arrays.toString(res1));
    }

}
