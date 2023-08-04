package com.timberliu.algorithm.leetcode.graph.minSpanningTree.no1584_2_minCostConnectPoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 *
 * @user liujie
 * @date 2023/8/4
 */
public class Solution1 {

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, dist(i, j, points)));
            }
        }
        edges.sort(Comparator.comparingInt(a -> a.len));

        UnionFind unionFind = new UnionFind(edges.size());
        int res = 0;
        int num = 0;
        for (Edge edge : edges) {
            if (unionFind.union(edge.x, edge.y)) {
                res += edge.len;
                num++;
                // n 个节点，n-1条边可全部连通
                if (num == n - 1) {
                    break;
                }
            }
        }
        return res;
    }

    private int dist(int i, int j, int[][] points) {
        int[] x = points[i];
        int[] y = points[j];
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    static class UnionFind {
        int[] node;
        int[] size;
        UnionFind(int n) {
            node = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                node[i] = i;
                size[i] = i;
            }
        }
        public int find(int p) {
            if (p != node[p]) {
                node[p] = find(node[p]);
            }
            return node[p];
        }
        public boolean union(int p, int q) {
            int first = find(p);
            int second = find(q);
            if (first == second) {
                return false;
            }
            node[first] = second;
            size[second] += size[first];
            return true;
        }
    }

    static class Edge {
        int x;
        int y;
        int len;
        Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.minCostConnectPoints(new int[][]{
                {3, 12}, {-2, 5}, {-4, 1}
        });
        System.out.println(res);
    }

}
