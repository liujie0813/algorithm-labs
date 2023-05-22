package com.timberliu.algorithm.company.hw.volume_a.logic.no063_2_excelSum;

import java.util.Scanner;

/**
 * 63. Excel 单元格数值统计
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int excelSum(String[][] arr, String find) {
		String[] finds = find.split(":");
		int[] startPosition = findPosition(finds[0]);
		int[] endPosition = findPosition(finds[1]);

		int res = 0;
		for (int i = startPosition[0]; i <= endPosition[0]; i++) {
			for (int j = startPosition[1]; j <= endPosition[1]; j++) {
				res += getVal(arr, i, j);
			}
		}
		return res;
	}

	private static int getVal(String[][] arr, int x, int y) {
		String str = arr[x][y];
		if (str.charAt(0) == '=') {
			int val;
			String formula = str.substring(1);
			if (str.contains("+")) {
				String[] split = formula.split("\\+");
				int firstVal = doGetVal(arr, split[0]);
				int secondVal = doGetVal(arr, split[1]);
				val = firstVal + secondVal;
			} else if (str.contains("-")) {
				String[] split = formula.split("-");
				int firstVal = doGetVal(arr, split[0]);
				int secondVal = doGetVal(arr, split[1]);
				val = firstVal - secondVal;
			} else {
				val = doGetVal(arr, formula);
			}
			arr[x][y] = val + "";
			return val;
		} else {
			return Integer.parseInt(str);
		}
	}

	private static int doGetVal(String[][] arr, String str) {
		if (Character.isDigit(str.charAt(0))) {
			return Integer.parseInt(str);
		} else {
			int[] position = findPosition(str);
			return getVal(arr, position[0], position[1]);
		}
	}
	
	private static int[] findPosition(String str) {
		return new int[]{Integer.parseInt(str.substring(1)) - 1, str.charAt(0) - 'A'};
	}

	/*
	 * 1 3
	 * 1 =A1+C1 3
	 * A1:C1
	 */
	/**
	 * 5 3
	 * 10 12 =C5
	 * 15 5 6
	 * 7 8 =3+C2
	 * 6 =B2-A1 =C2
	 * 7 5 3
	 * B2:C4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		scanner.nextLine();
		String[][] arr = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			arr[i] = scanner.nextLine().split(" ");
		}
		String find = scanner.nextLine();

		int res = excelSum(arr, find);
		System.out.println(res);
	}

}
