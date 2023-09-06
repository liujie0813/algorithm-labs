package com.timberliu.algorithm.company.hw.volume_b.new_add.section.no060_2_simpleMemoryPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static List<String> memoryAllocate(int n, String[][] strs) {
        LinkedList<int[]> used = new LinkedList<>();
        used.add(new int[]{100, Integer.MAX_VALUE});

        List<String> res = new ArrayList<>();
        for (String[] str : strs) {
            if ("REQUEST".equals(str[0])) {
                int left = 0;
                int len = Integer.parseInt(str[1]);
                if (len == 0) {
                    res.add("error");
                    continue;
                }
                boolean find = false;
                for (int i = 0; i < used.size(); i++) {
                    int right = left + len - 1;
                    if ((i == 0 && right < used.get(i)[0]) ||
                            (i > 0 && right < used.get(i)[0] && left > used.get(i - 1)[1])) {
                        // 小于第一个区间的左边界
                        // 或者小于当前区间的左边界，大于上一个区间的右边界
                        used.add(i, new int[]{left, right});
                        find = true;
                        break;
                    }
                    left = used.get(i)[1] + 1;
                }
                if (find) {
                    res.add(String.valueOf(left));
                } else {
                    res.add("error");
                }
            } else if ("RELEASE".equals(str[0])) {
                int addr = Integer.parseInt(str[1]);
                boolean release = false;
                for (int i = 0; i < used.size(); i++) {
                    if (addr == used.get(i)[0]) {
                        used.remove(addr);
                        release = true;
                        break;
                    }
                }
                if (!release) {
                    res.add("error");
                }
            }
        }
        return res;
    }

    /**
     * 5
     * REQUEST=10
     * REQUEST=20
     * RELEASE=0
     * REQUEST=20
     * REQUEST=10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] strs = new String[n][2];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine().split("=");
        }

        List<String> res = memoryAllocate(n, strs);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
