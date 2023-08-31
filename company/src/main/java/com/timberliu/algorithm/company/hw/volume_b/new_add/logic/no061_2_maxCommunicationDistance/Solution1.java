package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no061_2_maxCommunicationDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最大社交距离
 *
 * @user liujie
 * @date 2023/8/30
 */
public class Solution1 {

    public static int lastPersonPosition(int[] arr, int seatNum) {
        List<Integer> used = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                used.remove(Integer.valueOf(-arr[i]));
                continue;
            }
            if (i == 0) {
                res = 0;
                used.add(0);
            } else if (i == 1) {
                res = seatNum - 1;
                used.add(seatNum - 1);
            } else {
                int leftIndex = 0;
                int max = 0;
                for (int j = 1; j < used.size(); j++) {
                    Integer last = used.get(j - 1);
                    Integer cur = used.get(j);
                    // 没有空位 跳过
                    if (last + 1 == cur) {
                        continue;
                    }
                    int dis = (cur - last) / 2;
                    if (dis > max) {
                        max = dis;
                        leftIndex = last;
                    }
                }
                int dis = seatNum - 1 - used.get(used.size() - 1);
                if (dis > max) {
                    max = dis;
                    leftIndex = used.get(used.size() - 1);
                }

                res = leftIndex + max;
                used.add(res);
                used.sort(null);
            }
        }
        return res;
    }

    /**
     * 10
     * [1,1,1,1,-4,1]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seatNum = Integer.parseInt(scanner.next());
        String line = scanner.next();
        String[] splits = line.substring(1, line.length() - 1).split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = lastPersonPosition(arr, seatNum);
        System.out.println(res);
    }

}
