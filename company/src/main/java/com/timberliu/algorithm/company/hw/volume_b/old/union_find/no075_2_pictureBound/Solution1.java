package com.timberliu.algorithm.company.hw.volume_b.old.union_find.no075_2_pictureBound;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 图像物体的边界
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static int pictureBound(int m, int n, int[][] arr) {
        List<int[]> fives = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 5) {
                    fives.add(new int[]{i, j});
                }
            }
        }

        UnionFind unionFind = new UnionFind(fives.size());
        for (int i = 0; i < fives.size(); i++) {
            int x1 = fives.get(i)[0];
            int y1 = fives.get(i)[1];
            for (int j = i + 1; j < fives.size(); j++) {
                int x2 = fives.get(j)[0];
                int y2 = fives.get(j)[1];
                if (Math.abs(x1 - x2) <= 3 && Math.abs(y1 - y2) <= 3) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    static class UnionFind {
        int[] node;
        int count;
        public UnionFind(int n) {
            node = new int[n];
            count = n;
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
                count--;
            }
        }
    }

    /*
     * 6 6
     * 1 1 1 1 1 1
     * 1 5 1 1 1 1
     * 1 1 1 1 1 1
     * 1 1 1 1 1 1
     * 1 1 1 1 5 1
     * 1 1 1 1 1 1
     */
    /**
     * 6 6
     * 1 1 1 1 1 1
     * 1 5 1 1 1 1
     * 1 1 1 1 1 1
     * 1 1 1 1 1 1
     * 1 1 1 1 1 1
     * 1 1 1 1 1 5
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

        int res = pictureBound(m, n, arr);
        System.out.println(res);
    }

}
