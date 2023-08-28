package com.timberliu.algorithm.company.hw.volume_b.new_add.container.no023_2_taskSort;

import java.util.*;

/**
 * 23. 打印任务排序
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    public static int[] taskSort(int[] arr) {
        Deque<int[]> deque = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -arr[i]));
        for (int i = 0; i < arr.length; i++) {
            deque.offer(new int[]{i, arr[i]});
            pq.offer(i);
        }

        int[] res = new int[arr.length];
        int index = 0;
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            Integer max = pq.peek();
            if (poll[1] == arr[max]) {
                res[poll[0]] = index++;
                pq.poll();
            } else {
                deque.offerLast(poll);
            }
        }
        return res;
    }

    /**
     * 9,3,5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splits = line.split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int[] res = taskSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i < res.length - 1) {
                System.out.print(",");
            }
        }
    }

}
