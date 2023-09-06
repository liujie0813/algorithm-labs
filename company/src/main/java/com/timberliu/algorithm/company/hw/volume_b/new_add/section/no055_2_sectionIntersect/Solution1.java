package com.timberliu.algorithm.company.hw.volume_b.new_add.section.no055_2_sectionIntersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 区间交集
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static List<int[]> sectionIntersect(int n, int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> commons = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int curLeft = arr[i][0];
            int curRight = arr[i][1];
            for (int j = 0; j < i; j++) {
                int lastRight = arr[j][1];
                if (curLeft <= lastRight) {
                    commons.add(new int[]{curLeft, Math.min(lastRight, curRight)});
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        res.add(commons.get(0));
        for (int i = 1; i < commons.size(); i++) {
            int[] cur = commons.get(i);
            int[] tail = res.get(res.size() - 1);
            if (cur[0] <= tail[1]) {
                tail[1] = Math.max(cur[1], tail[1]);
            } else {
                res.add(cur);
            }
        }
        return res;
    }

    /**
     * 4
     * 0 3
     * 1 3
     * 3 5
     * 3 6
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        List<int[]> res = sectionIntersect(n, arr);
        if (res.isEmpty()) {
            System.out.println("None");
        } else {
            for (int[] r : res) {
                System.out.println(r[0] + " " + r[1]);
            }
        }
    }

}
