package com.timberliu.algorithm.company.hw.volume_b.new_add.math.no123_2_squareNum;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 构成正方形的数量
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int squareNum(int[][] arr) {
        Set<String> set = new HashSet<>();
        for (int[] a : arr) {
            set.add(a[0] + " "+ a[1]);
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int firstX = arr[i][0], firstY = arr[i][1];
            for (int j = i + 1; j < arr.length; j++) {
                int secondX = arr[j][0], secondY = arr[j][1];

                int x1 = firstX + secondY - firstY, y1 = firstY - (secondX - firstX);
                int x2 = secondX + secondY - firstY, y2 = secondY - (secondX - firstX);
                if (set.contains(x1 + " " + y1) && set.contains(x2 + " " + y2)) {
                    count++;
                }

                int x3 = firstX - (secondY - firstY), y3 = firstY + (secondX - firstX);
                int x4 = secondX - (secondY - firstY), y4 = secondY + (secondX - firstX);
                if (set.contains(x3 + " " + y3) && set.contains(x4 + " " + y4)) {
                    count++;
                }
            }
        }
        return count / 4;
    }

    /**
     * 4
     * 0 0
     * 1 2
     * 3 1
     * 2 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        int res = squareNum(arr);
        System.out.println(res);
    }

}
