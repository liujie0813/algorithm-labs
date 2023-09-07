package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no999_2_shopping;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * 购物
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static List<Integer> shopping(int n, int[] arr, int k) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(arr);
        // [curSum, nextId]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + arr[a[1]]));
        pq.offer(new int[]{0, 0});

        for (int i = 0; i < k; i++) {
            int[] combine = pq.poll();
            int lastSum = combine[0];
            int curId = combine[1];
            int curSum = lastSum + arr[curId];
            res.add(curSum);

            if (curId + 1 < n) {
                // 不要当前元素，看下一个元素
                pq.offer(new int[]{ lastSum, curId + 1 });
                // 要当前元素，看下一个元素
                pq.offer(new int[]{ curSum, curId + 1 });
            }
        }
        return res;
    }

    /**
     * 5 6
     * 1 1 2 3 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<Integer> res = shopping(n, arr, k);
        for (Integer r : res) {
            System.out.println(r);
        }
    }

}
