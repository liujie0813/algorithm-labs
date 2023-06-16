package com.timberliu.algorithm.company.hw.exercise.no03.no144_1_jobNumber;

import java.util.Scanner;

/**
 * 144. 工号不够用了
 *
 * @author liujie
 * @date 2023/6/16
 */

public class Solution1 {

	public static int minNumLen(int personNum, int letterLen) {
		int first = (int) Math.pow(26, letterLen);
		int numberLen = 1;
		while (first * (int) Math.pow(10, numberLen) < personNum) {
			numberLen++;
		}
		return numberLen;
	}

	/*
	 * 2600 1
	 */
	/**
	 * 26001 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int personNum = scanner.nextInt();
		int letterLen = scanner.nextInt();

		int res = minNumLen(personNum, letterLen);
		System.out.println(res);
	}

}
