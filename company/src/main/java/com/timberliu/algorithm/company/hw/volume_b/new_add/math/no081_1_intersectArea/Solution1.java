package com.timberliu.algorithm.company.hw.volume_b.new_add.math.no081_1_intersectArea;

import java.util.Scanner;

/**
 * 矩形相交的面积
 *
 *  [x, y, w, h]
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int intersectArea(int[][] arr) {
        int[] first = arr[0], second = arr[1], third = arr[2];

        int width = Math.min(Math.min(first[0] + first[2], second[0] + second[2]), third[0] + third[2])
                - Math.max(Math.max(first[0], second[0]), third[0]);
        if (width < 0) {
            return 0;
        }

        int height = Math.min(Math.min(first[1], second[1]), third[1])
                - Math.max(Math.max(first[1] - first[3], second[1] - second[3]), third[1] - second[3]);
        if (height < 0) {
            return 0;
        }
        return width * height;
    }

    /**
     * 1 6 4 4
     * 3 5 3 4
     * 0 3 7 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int res = intersectArea(arr);
        System.out.println(res);
    }

}
