package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no078_2_searchDict;

import java.util.Scanner;

/**
 * 78. 查字典
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prefix = scanner.next();
        int len = scanner.nextInt();
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            String str = scanner.next();
            if (str.length() >= prefix.length() && str.startsWith(prefix)) {
                System.out.println(str);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

}
