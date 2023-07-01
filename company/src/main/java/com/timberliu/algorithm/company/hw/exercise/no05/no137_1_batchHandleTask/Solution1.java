package com.timberliu.algorithm.company.hw.exercise.no05.no137_1_batchHandleTask;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Timber
 * @date 2023/6/23
 */
public class Solution1 {

	public static int minNum(int[][] tasks) {
		Arrays.sort(tasks, (a, b) -> a[1] - b[1]);

		int res = 0;
		int[] last = tasks[tasks.length - 1];
		// 所有运行时间点
		boolean[] run = new boolean[last[1] + 1];
		for (int[] task : tasks) {
			int start = task[0], end = task[1], period = task[2];
			// 当前任务，还需运行的时间点数
			for (int i = start; i <= end; i++) {
				if (run[i]) {
					period--;
				}
			}
			// 如果 period 大于 0，则需要新增运行点
			// 尽量在区间 [start, end] 的后缀上运行，如此下一个区间才可能统计到更多已有的时间点
			int index = end;
			while (period > 0) {
				if (!run[index]) {
					run[index] = true;
					--period;
					++res;
				}
				index--;
			}
		}
		return res;
	}





	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] splits = line.substring(1, line.length() - 1).split(",");
		int[][] matrix = new int[splits.length][3];
		for (int i = 0; i < splits.length; i++) {
			String substring = splits[i].substring(1, splits[i].length() - 1);
			String[] subSplits = substring.split(",");
			for (int j = 0; j < subSplits.length; j++) {
				matrix[i][j] = Integer.parseInt(subSplits[j]);
			}
		}

		int res = minNum(matrix);
		System.out.println(res);
	}

}
