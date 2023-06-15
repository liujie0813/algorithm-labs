package com.timberliu.algorithm.company.hw.exercise.no02.no147_1_reliableCar;

import java.util.Scanner;

/**
 * 147. 靠谱的车
 *
 *  相当于 9 进制
 *
 * @author liujie
 * @date 2023/6/15
 */

public class Solution1 {

	public static int reliableCar(int val) {
		int cnt = 0;
		int cur = 1;
		while (cur < val) {
			String str = String.valueOf(cur);
			int index = -1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '4') {
					index = i;
					break;
				}
			}
			if (index == -1) {
				cur++;
			} else {
				char[] chars = str.toCharArray();
				chars[index]++;
				int next = Integer.parseInt(new String(chars));
				cnt += next - cur;
				cur = next;
			}
		}
		return val - cnt;
	}

	public static int reliableCar1(int val) {
		String[] splits = String.valueOf(val).split("");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			if (a > 4) {
				a--;
			}
			a *= Math.pow(9, arr.length - i - 1);
			res += a;
		}
		return res;
	}

	/**
	 * 100
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int val = scanner.nextInt();
		int res = reliableCar1(val);
		System.out.println(res);
	}

}
