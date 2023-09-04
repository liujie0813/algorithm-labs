package com.timberliu.algorithm.company.hw.volume_b.old.backtrack.no035_2_nameFind;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 快速人名查找
 *
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    public static List<String> findName(String[] strs, String find) {
        List<String> res = new ArrayList<>();
        for (String str : strs) {
            String[] arr = str.split(" ");
            if (backtrack(arr, 0, find, 0)) {
                res.add(str);
            }
        }
        return res;
    }

    private static boolean backtrack(String[] arr, int i, String find, int index) {
        if (index == find.length()) {
            return i == arr.length;
        }
        if (i == arr.length) {
            return false;
        }
        for (int j = 0; j < arr[i].length() && index < find.length(); j++) {
            if (arr[i].charAt(j) != find.charAt(index)) {
                return false;
            }
            if (backtrack(arr, i + 1, find, index + 1)) {
                return true;
            } else {
                index++;
            }
        }
        return false;
    }

    /**
     * zhang san,zhang san san
     * zhasasa
     */
    /**
     * zhang san san,zhang an sa,zhang seng,zhang seng a
     * zhas
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(",");
        String find = scanner.nextLine();

        List<String> res = findName(splits, find);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

}
