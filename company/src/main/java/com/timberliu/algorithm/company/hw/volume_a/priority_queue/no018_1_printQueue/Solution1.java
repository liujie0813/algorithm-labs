package com.timberliu.algorithm.company.hw.volume_a.priority_queue.no018_1_printQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	/**
	 * 7
	 * IN 1 1
	 * IN 1 2
	 * IN 1 3
	 * IN 2 1
	 * OUT 1
	 * OUT 2
	 * OUT 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		// index, priority
		List<PriorityQueue<int[]>> printers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			printers.add(new PriorityQueue<>((a, b) -> {
				if (a[1] == b[1]) {
					return a[0] - b[0];
				}
				return b[1] - a[1];
			}));
		}
		for (int i = 0; i < n; i++) {
			String[] strs = scanner.nextLine().split(" ");
			if ("IN".equals(strs[0])) {
				int no = Integer.parseInt(strs[1]);
				int priority = Integer.parseInt(strs[2]);

				PriorityQueue<int[]> printer = printers.get(no - 1);
				printer.offer(new int[]{i + 1, priority});
			} else if ("OUT".equals(strs[0])) {
				int no = Integer.parseInt(strs[1]);
				PriorityQueue<int[]> printer = printers.get(no - 1);
				if (printer.isEmpty()) {
					System.out.println("NULL");
				} else {
					System.out.println(printer.poll()[0]);
				}
			}
		}
	}

}
