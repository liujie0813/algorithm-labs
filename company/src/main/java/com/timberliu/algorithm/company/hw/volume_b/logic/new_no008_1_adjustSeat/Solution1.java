package com.timberliu.algorithm.company.hw.volume_b.logic.new_no008_1_adjustSeat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8. 座位调整
 *
 * @author liujie
 * @date 2023/5/29
 */

public class Solution1 {

	public static int adjustSeat(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				boolean isLeftEmpty = i == 0 || arr[i - 1] == 0;
				boolean isRightEmpty = i == arr.length - 1 || arr[i + 1] == 0;
				if (isLeftEmpty && isRightEmpty) {
					res++;
					arr[i] = 1;
					i++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
		int res = adjustSeat(arr);
		System.out.println(res);
	}

}
