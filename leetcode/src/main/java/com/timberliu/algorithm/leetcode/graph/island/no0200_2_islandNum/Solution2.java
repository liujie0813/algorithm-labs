package com.timberliu.algorithm.leetcode.graph.island.no0200_2_islandNum;

/**
 * 200. 岛屿数量
 *
 * @user liujie
 * @date 2023/8/3
 */
public class Solution2 {

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind unionFind = new UnionFind(m * n);
        int zero = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    zero++;
                } else {
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.union(i * n + j, i * n + j + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        unionFind.union(i * n + j, (i + 1) * n + j);
                    }
                }
            }
        }
        return unionFind.count() - zero;
    }

    static class UnionFind {
        private int[] node;
        private int count;
        public UnionFind(int n) {
            this.node = new int[n];
            for (int i = 0; i < n; i++) {
                this.node[i] = i;
            }
            this.count = n;
        }
        public int find(int p) {
            while (p != node[p]) {
                p = node[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int first = find(p);
            int second = find(q);
            if (first == second) {
                return;
            }
            node[first] = second;
            count--;
        }
        public int count() { return count; }
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
//        int res = solution1.numIslands(new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        });
//        System.out.println(res);

        int res1 = solution1.numIslands(new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
        });
        System.out.println(res1);
    }

}
