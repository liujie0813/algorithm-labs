package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no059_2_errorCodeRate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 计算误码率
 *
 * @user liujie
 * @date 2023/8/29
 */
public class Solution1 {

    private static List<char[]> parseLine(String str) {
        List<char[]> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int num = 0;
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                num *= 10;
                num += str.charAt(index) - '0';
                index++;
            }
            char c = str.charAt(index);
            res.add(new char[]{c, (char) num});
            index++;
        }
        return res;
    }

    /*
     * 3A3B
     * 2A4B
     */
    /*
     * 5Y5Z
     * 5Y5Z
     */
    /**
     * 5Y5Z
     * 10Y
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();

        List<char[]> firstList = parseLine(first);
        List<char[]> secondList = parseLine(second);

        int total = 0;
        for (char[] chars : firstList) {
            total += chars[1];
        }

        int i = 0, j = 0;
        int count = 0;
        while (i < firstList.size() && j < secondList.size()) {
            char[] firstChars = firstList.get(i);
            char[] secondChars = secondList.get(j);

            int min = Math.min(firstChars[1], secondChars[1]);
            if (firstChars[1] == secondChars[1]) {
                if (firstChars[0] != secondChars[0]) {
                    count += firstChars[1];
                }
                i++;
                j++;
            } else if (firstChars[1] < secondChars[1]) {
                if (firstChars[0] != secondChars[0]) {
                    count += firstChars[1];
                }
                secondChars[1] -= min;
                i++;
            } else {
                if (firstChars[0] != secondChars[0]) {
                    count += secondChars[1];
                }
                firstChars[1] -= min;
                j++;
            }
        }
        System.out.println(count + "/" + total);
    }

}
