package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no145_1_stringEncrypt;

import java.util.Scanner;

/**
 * 字符串加密
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static String[] stringEncrypt(String[] strings) {
        int[] dp = new int[50];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < 50; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 26;
        }

        String[] res = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            StringBuilder sb = new StringBuilder();
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                int ch = str.charAt(j) + dp[j];
                if (ch > 'z') {
                    ch -= 26;
                }
                sb.append((char) ch);
            }
            res[i] = sb.toString();
        }
        return res;
    }

    /*
     * 1
     * xy
     */
    /**
     * 1
     * abcdefghijklmnopqrstuvwxyz
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        String[] res = stringEncrypt(strings);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
