package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no994_1_isGetAward;

import java.util.Scanner;

/**
 * 考勤信息
 *
 * @author liujie
 * @date 2023/5/26
 */

public class Solution1 {

	public static boolean[] isGetAward(String[][] arr) {
		boolean[] res = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String[] strs = arr[i];
			int absentCnt = 0;
			int abnormalCnt = 0;
			boolean getAward = true;

			for (int j = 0; j < strs.length; j++) {
				switch (strs[j]) {
					case "absent":
						// 缺勤超过 1 次
						if (++absentCnt > 1) {
							getAward = false;
						}
						++abnormalCnt;
						break;
					case "late":
						// 连续的迟到
						if (j > 0 && "late".equals(strs[j - 1])) {
							getAward = false;
						}
						++abnormalCnt;
						break;
					case "leaveeearly":
						// 连续的早退
						if (j > 0 && "leaveeearly".equals(strs[j - 1])) {
							getAward = false;
						}
						++abnormalCnt;
						break;
				}
				// 连续 7 次
				if (j >= 7 && !"present".equals(strs[j - 7])) {
					abnormalCnt--;
				}
				// 缺勤/迟到/早退 超过 3 次
				if (abnormalCnt > 3) {
					getAward = false;
				}
				if (!getAward) {
					break;
				}
			}

			res[i] = getAward;
		}
		return res;
	}

	/*
	 * 2
	 * present
	 * present absent present present leaveearly present absent
	 */
	/**
	 * 2
	 * present
	 * present absent present present leaveearly present late
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[][] arr = new String[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextLine().split(" ");
		}

		boolean[] res = isGetAward(arr);
		for (boolean val : res) {
			System.out.println(val);
		}
	}

}
