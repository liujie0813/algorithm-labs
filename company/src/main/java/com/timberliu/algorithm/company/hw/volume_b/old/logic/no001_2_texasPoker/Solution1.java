package com.timberliu.algorithm.company.hw.volume_b.old.logic.no001_2_texasPoker;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 德州扑克
 *
 * @user liujie
 * @date 2023/9/13
 */
public class Solution1 {

    public static int maxPoker(String[][] strings) {
        char[][] transfer = new char[5][2];
        for (int i = 0; i < strings.length; i++) {
            transfer[i][1] = strings[i][1].charAt(0);
            char ch = strings[i][0].charAt(0);
            switch (ch) {
                case 'A':
                    transfer[i][0] = 12;
                    break;
                case 'K':
                    transfer[i][0] = 11;
                    break;
                case 'Q':
                    transfer[i][0] = 10;
                    break;
                case 'J':
                    transfer[i][0] = 9;
                    break;
                default:
                    transfer[i][0] = (char) (ch - 2);
                    break;
            }
        }

        Arrays.sort(transfer, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        if (isSameColor(transfer) && isContinuous(transfer)) {
            return 1;
        }
        if (isFour(transfer)) {
            return 2;
        }
        if (isThreeTwo(transfer)) {
            return 3;
        }
        if (isSameColor(transfer)) {
            return 4;
        }
        if (isContinuous(transfer)) {
            return 5;
        }
        if (isThree(transfer)) {
            return 6;
        }
        return 0;
    }

    private static boolean isSameColor(char[][] chars) {
        char color = chars[0][1];
        for (int i = 1; i < 5; i++) {
            if (color != chars[i][1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContinuous(char[][] chars) {
        for (int i = 1; i < 5; i++) {
            if (chars[i][0] != chars[i - 1][0] + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 4 4 4 4 5
     * 4 5 5 5 5
     */
    private static boolean isFour(char[][] chars) {
        int i = 0;
        while (chars[i][0] == chars[i + 1][0]) {
            i++;
        }
        int j = i + 1;
        while (j + 1 < chars.length && chars[j][0] == chars[j + 1][0]) {
            j++;
        }
        return (i == 3 || i == 0) && j == chars.length - 1;
    }

    /**
     * 2 2 2 3 3
     * 3 3 4 4 4
     */
    private static boolean isThreeTwo(char[][] chars) {
        int i = 0;
        while (chars[i][0] == chars[i + 1][0]) {
            i++;
        }
        int j = i + 1;
        while (j + 1 < chars.length && chars[j][0] == chars[j + 1][0]) {
            j++;
        }
        return (i == 2 || i == 1) && j == chars.length - 1;
    }

    private static boolean isThree(char[][] chars) {
        char ch = chars[0][0];
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < 5; i++) {
            if (chars[i][0] == ch) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                ch = chars[i][0];
                cnt = 1;
            }
        }
        return max == 3;
    }

    /**
     * 9 S
     * 5 S
     * 6 S
     * 7 S
     * 8 S
     */
    /**
     * 9 D
     * 9 C
     * 9 S
     * 9 H
     * 8 S
     */
    /**
     * 9 D
     * 8 C
     * 9 S
     * 9 H
     * 8 S
     */
    /**
     * 9 D
     * 2 D
     * A D
     * Q D
     * 10 D
     */
    /**
     * 9 D
     * 8 C
     * 5 S
     * 6 H
     * 7 S
     */
    /**
     * 9 D
     * 8 C
     * 9 S
     * 9 H
     * 7 S
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] chars = new String[5][2];
        for (int i = 0; i < 5; i++) {
            chars[i] = scanner.nextLine().split(" ");
        }

        int res = maxPoker(chars);
        System.out.println(res);
    }

}
