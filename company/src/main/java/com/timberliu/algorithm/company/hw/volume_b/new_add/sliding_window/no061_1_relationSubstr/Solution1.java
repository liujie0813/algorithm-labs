package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no061_1_relationSubstr;

import java.util.Scanner;

/**
 * 关联子串
 *
 *  尺取法，常用于解决最小覆盖子串问题
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    private static int relationSubstr(String first, String second) {
        int[] need = new int[26];
        for (int i = 0; i < first.length(); i++) {
            need[first.charAt(i) - 'a']++;
        }
        int needCnt = 0;
        for (int a : need) {
            if (a != 0) {
                needCnt++;
            }
        }

        int windowCnt = 0;
        int left = 0, right = 0;
        int[] window = new int[26];
        while (right < second.length()) {
            int cur = second.charAt(right) - 'a';
            window[cur]++;

            if (window[cur] == need[cur]) {
                windowCnt++;
                if (windowCnt == needCnt) {
                    return left;
                }
            }

            while (window[cur] > need[cur]) {
                int lIndex = second.charAt(left) - 'a';
                window[lIndex]--;
                if (window[lIndex] != need[lIndex]) {
                    windowCnt--;
                }
                left++;
            }
            right++;
        }
        return -1;
    }

    /**
     * abc efghicbaiii
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");

        int res = relationSubstr(splits[0], splits[1]);
        System.out.println(res);
    }

}
