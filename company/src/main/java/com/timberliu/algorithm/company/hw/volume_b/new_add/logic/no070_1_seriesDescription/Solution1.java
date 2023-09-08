package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no070_1_seriesDescription;

import java.util.Scanner;

/**
 * 数列描述
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static String seriesDescription(int n) {
        String res = "1";
        for (int i = 0; i < n; i++) {
            char ch = res.charAt(0);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    cnt++;
                } else {
                    sb.append(cnt).append(ch);
                    ch = res.charAt(j);
                    cnt = 1;
                }
            }
            sb.append(cnt).append(ch);
            res = sb.toString();
        }
        return res;
    }

    /**
     * 4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            String res = seriesDescription(arr[i]);
            System.out.println(res);
        }
    }

}
