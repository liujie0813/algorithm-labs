package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no051_2_unhappyChild;

import java.util.*;

/**
 * 不开心的朋友
 *
 * @user liujie
 * @date 2023/8/30
 */
public class Solution1 {

    public static int unhappyChild(int[] arr, int carNum) {
        Set<Integer> playing = new HashSet<>();
        LinkedHashSet<Integer> waiting = new LinkedHashSet<>();
        int res = 0;
        for (int kid : arr) {
            if (playing.contains(kid)) {
                // 已经玩过，要离开了
                playing.remove(kid);
                // 有等待的，选一个去玩
                if (!waiting.isEmpty()) {
                    playing.add(waiting.iterator().next());
                }
            } else if (waiting.contains(kid)) {
                // 不等了，不开心离开
                res++;
                waiting.remove(kid);
            } else {
                // 新的小朋友，有车则去玩
                if (playing.size() < carNum) {
                    playing.add(kid);
                } else {
                    waiting.add(kid);
                }
            }
        }
        return res;
    }

    /*
     * 1
     * 1 2 1 2
     */
    /**
     * 1
     * 1 2 2 3 1 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNum = Integer.parseInt(scanner.nextLine());
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = unhappyChild(arr, carNum);
        System.out.println(res);
    }

}
