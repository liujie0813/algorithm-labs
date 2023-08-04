package com.timberliu.algorithm.leetcode.graph.dfs.no0399_2_calcEquation;

import java.util.*;

/**
 * 399. 除法求值
 *
 * @user liujie
 * @date 2023/8/4
 */
public class Solution1 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Cell>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            graph.computeIfAbsent(first, (val) -> new ArrayList<>()).add(new Cell(second, values[i]));
            graph.computeIfAbsent(second, (val) -> new ArrayList<>()).add(new Cell(first, 1 / values[i]));
        }

        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            dfs(src, dest, 1.0, res, i, graph, new HashSet<>());
        }
        return res;
    }

    private void dfs(String src, String dest, double curVal, double[] res, int index, Map<String, List<Cell>> graph, Set<String> visited) {
        if (src.equals(dest) && graph.containsKey(src)) {
            res[index] = curVal;
            return;
        }
        visited.add(src);
        List<Cell> cells = graph.get(src);
        if (cells == null) {
            return;
        }
        for (Cell cell : cells) {
            if (!visited.contains(cell.dst)) {
                dfs(cell.dst, dest, curVal * cell.val, res, index, graph, visited);
            }
        }
    }

    static class Cell {
        String dst;
        double val;
        Cell(String dst, double val) {
            this.dst = dst;
            this.val = val;
        }
    }

    /**
     * equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     */
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = new double[]{ 2.0, 3.0 };
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        double[] res = solution1.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }

}
