package com.timberliu.algorithm.company.hw.priority_queue.no117_1_bankQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 117. 银行插队
 *
 * @author liujie
 * @date 2023/4/12
 */

public class Solution1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// 优先级队列，默认为小顶堆
		// 按照 a[1] 即优先级排序，如果优先级相同，则按自然顺序排序
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
		for (int i = 0; i < n; i++) {
			String flag = scanner.next();
			if ("a".equals(flag)) {
				int num = scanner.nextInt();
				int x = scanner.nextInt();
				pq.offer(new int[]{num, x});
			} else if ("p".equals(flag)) {
				int[] head = pq.poll();
				System.out.println(head[0]);
			}
		}
	}

}
