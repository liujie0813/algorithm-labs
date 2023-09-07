package com.timberliu.algorithm.company.hw.volume_b.old.union_find.no037_2_cityAggregation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 城市聚集度
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static String cityAggr(int n, List<int[]> connections) {
        int minDp = Integer.MAX_VALUE;
        List<Integer> cities = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            UnionFind unionFind = new UnionFind(n);
            for (int[] connection : connections) {
                if (connection[0] != i && connection[1] != i) {
                    unionFind.union(connection[0] - 1, connection[1] - 1);
                }
            }
            int size = unionFind.maxConnectSize();
            if (size < minDp) {
                minDp = size;
                cities.clear();
                cities.add(i);
            } else if (size == minDp) {
                cities.add(i);
            }
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Integer city : cities) {
            stringJoiner.add(String.valueOf(city));
        }
        return stringJoiner.toString();
    }

    static class UnionFind {
        int[] node;
        int[] size;
        public UnionFind(int n) {
            node = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                node[i] = i;
                size[i] = 1;
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
                size[second] += size[first];
            }
        }
        // 最大的那个连通分量的元素个数
        public int maxConnectSize() {
            int max = 0;
            for (int i = 0; i < size.length; i++) {
                // 只取根节点对应的数量
                if (node[i] == i) {
                    max = Math.max(max, size[i]);
                }
            }
            return max;
        }
    }

    /*
     * 5
     * 1 2
     * 2 3
     * 3 4
     * 4 5
     */
    /**
     * 6
     * 1 2
     * 2 3
     * 2 4
     * 3 5
     * 3 6
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> connections = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if ("".equals(s)) {
                break;
            } else {
                String[] splits = s.split(" ");
                connections.add(new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])});
            }
        }
        String res = cityAggr(n, connections);
        System.out.println(res);
    }

}
