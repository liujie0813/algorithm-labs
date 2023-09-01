package com.timberliu.algorithm.company.hw.volume_b.old.math.no015_1_gouguTuple;

import java.util.*;

/**
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static List<int[]> gouguTuple(int n, int m) {
        Set<Integer> set = new HashSet<>();
        for (int i = n; i <= m; i++) {
            set.add(i * i);
        }

        List<int[]> list = new ArrayList<>();
        for (int i = n; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                int val = i * i + j * j;
                if (set.contains(val)) {
                    list.add(new int[]{i, j, (int) Math.sqrt(val)});
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        for (int[] tuple : list) {
            if (!isPrime(tuple[0], tuple[1]) ||
                    !isPrime(tuple[1], tuple[2]) ||
                    !isPrime(tuple[0], tuple[2])) {
                continue;
            }
            res.add(tuple);
        }
        return res;
    }

    /**
     * 辗转相除
     */
    private static boolean isPrime(int a, int b) {
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a == 1;
    }

    /**
     * 1 20
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<int[]> res = gouguTuple(n, m);
        for (int[] a : res) {
            System.out.println(a[0] + " " + a[1] + " " + a[2]);
        }
    }

}
