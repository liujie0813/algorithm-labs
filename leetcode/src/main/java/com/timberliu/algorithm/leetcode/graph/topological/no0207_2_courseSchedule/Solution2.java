package com.timberliu.algorithm.leetcode.graph.topological.no0207_2_courseSchedule;

import java.util.*;

/**
 * 207. 课程表
 *
 * DFS 判断是否有环
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] r : prerequisites) {
            List<Integer> list = edges.computeIfAbsent(r[1], (val) -> new ArrayList<>());
            list.add(r[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if (!dfs(edges, i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> edges, int index, boolean[] visited) {
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        List<Integer> next = edges.get(index);
        if (next == null) {
            return true;
        }
        for (Integer a : next) {
            if (!dfs(edges, a, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        boolean res1 = solution1.canFinish(2, new int[][]{{1, 0}});
        System.out.println(res1);
    }

}
