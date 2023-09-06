package com.timberliu.algorithm.company.hw.volume_b.new_add.section.no085_1_lampLighting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 路灯照明
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static int notLighting(int n, int[] arr) {
        int[][] sections = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            int a = i * 100;
            if (i == 0) {
                sections[i] = new int[]{0, arr[i]};
            } else if (i == arr.length - 1) {
                sections[i] = new int[]{a - arr[i], a};
            } else {
                sections[i] = new int[]{a - arr[i], a + arr[i]};
            }
        }

        Arrays.sort(sections, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int res = 0;
        int end = sections[0][1];
        for (int i = 1; i < sections.length; i++) {
            if (sections[i][0] <= end) {
                end = Math.max(end, sections[i][1]);
            } else {
                res += sections[i][0] - end;
                end = sections[i][1];
            }
        }
        return res;
    }

    /*
     * 2
     * 50 50
     */
    /**
     * 4
     * 50 70 20 70
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = notLighting(n, arr);
        System.out.println(res);
    }

}
