package com.timberliu.algorithm.company.hw.volume_b.old.union_find.no083_2_happyWeekend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 欢乐的周末
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static int happyWeekend(int m, int n, int[][] arr) {
        UnionFind unionFind = new UnionFind(m * n);

        List<Integer> persons = new ArrayList<>();
        List<Integer> restaurants = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    continue;
                }
                int p = i * n + j;
                if (arr[i][j] == 2) {
                    persons.add(p);
                } else if (arr[i][j] == 3) {
                    restaurants.add(p);
                }

                for (int[] direction : directions) {
                    int newI = direction[0] + i;
                    int newJ = direction[1] + j;
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && arr[newI][newJ] != 1) {
                        unionFind.union(p, newI * n + newJ);
                    }
                }
            }
        }

        int first = unionFind.find(persons.get(0));
        int second = unionFind.find(persons.get(1));
        // 如果两个人不联通，直接返回
        if (first != second) {
            return 0;
        }
        int res = 0;
        for (Integer restaurant : restaurants) {
            // 和饭店联通
            if (unionFind.find(restaurant) == first) {
                res++;
            }
        }
        return res;
    }

    private static final int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static class UnionFind {
        private final int[] node;
        public UnionFind(int n) {
            node = new int[n];
            for (int i = 0; i < n; i++) {
                node[i] = i;
            }
        }
        public int find(int p) {
            if (p != node[p]) {
                node[p] = find(node[p]);
            }
            return node[p];
        }
        public void union(int p, int q) {
            int first = find(p);
            int second = find(q);
            if (first != second) {
                node[first] = second;
            }
        }
    }

    /*
     * 4 4
     * 2 1 1 3
     * 0 1 2 1
     * 0 3 0 0
     * 0 0 0 3
     */
    /**
     * 4 4
     * 2 1 0 3
     * 0 1 2 1
     * 0 3 0 0
     * 0 0 0 0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int res = happyWeekend(m, n, arr);
        System.out.println(res);
    }

}
