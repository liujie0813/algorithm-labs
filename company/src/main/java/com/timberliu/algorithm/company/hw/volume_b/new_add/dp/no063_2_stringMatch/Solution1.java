package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no063_2_stringMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 字符匹配
 *
 * dp[i][j]：考虑 str 中以 i 结尾，match 中以 j 结尾的是否匹配
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static String stringMatch(String[] strings, String match) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (matcher(strings[i], match)) {
                res.add(i);
            }
        }
        if (res.isEmpty()) {
            return "-1";
        }
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Integer r : res) {
            stringJoiner.add(String.valueOf(r));
        }
        return stringJoiner.toString();
    }

    private static boolean matcher(String str, String match) {
        // 添加前缀空字符，方便初始化，只需要 dp[0][0] 置为 ture 即可
        str = " " + str;
        match = " " + match;
        int m = str.length(), n = match.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        for (int i = 0; i < m; i++) {
            // match 第一个字符为 ' '，dp[i][0] 一定为 false，不用判断了
            for (int j = 1; j < n; j++) {
                if (match.charAt(j) == '*') {
                    // 匹配 0 个，或匹配 1 个
                    dp[i][j] = (j >= 2 && dp[i][j - 2]) ||
                            (i >= 1 && dp[i - 1][j] && (str.charAt(i) == match.charAt(j - 1) || match.charAt(j - 1) == '.'));
                } else {
                    dp[i][j] = i >= 1 && dp[i - 1][j - 1] && (str.charAt(i) == match.charAt(j) || match.charAt(j) == '.');
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * ab abc bsd
     * .*
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String match = scanner.nextLine();

        String res = stringMatch(strings, match);
        System.out.println(res);
    }

}
