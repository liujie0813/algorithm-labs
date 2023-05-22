package com.timberliu.algorithm.company.hw.volume_a.logic.no065_1_maxVersion;

import java.util.Scanner;

/**
 * 65. 获取最大软件版本号
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static String maxVersion(String version1, String version2) {
		String[] v1Split = version1.split("-");
		String[] version1Number = v1Split[0].split("\\.");

		String[] v2Split = version2.split("-");
		String[] version2Number = v2Split[0].split("\\.");

		for (int i = 0; i < 3; i++) {
			int v1Number = i < version1Number.length ? Integer.parseInt(version1Number[i]) : 0;
			int v2Number = i < version2Number.length ? Integer.parseInt(version2Number[i]) : 0;
			if (v1Number > v2Number) {
				return version1;
			} else if (v1Number < v2Number) {
				return version2;
			}
		}
		if (v2Split.length == 1) {
			return version1;
		} else if (v1Split.length == 1) {
			return version2;
		} else {
			return v1Split[1].compareTo(v2Split[1]) >= 0 ? version1 : version2;
		}
	}

	/*
	 * 2.5.1-C
	 * 1.4.2-D
	 */
	/*
	 * 1.05.1
	 * 1.5.01
	 */
	/*
	 * 1.5
	 * 1.5.0
	 */
	/**
	 * 1.5.0-A
	 * 1.5.0-a
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String version1 = scanner.nextLine();
		String version2 = scanner.nextLine();
		String res = maxVersion(version1, version2);
		System.out.println(res);
	}

}
