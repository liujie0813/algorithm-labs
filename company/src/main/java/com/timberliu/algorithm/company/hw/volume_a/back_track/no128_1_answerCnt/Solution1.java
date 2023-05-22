package com.timberliu.algorithm.company.hw.volume_a.back_track.no128_1_answerCnt;

import java.util.Scanner;

/**
 * 128. 新员工考试
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int answerCnt(int needScore) {
		int[] question = new int[25];
		for (int i = 0; i < 10; i++) {
			question[i] = 2;
		}
		for (int i = 10; i < 20; i++) {
			question[i] = 4;
		}
		for (int i = 20; i < 25; i++) {
			question[i] = 8;
		}
		int[] res = {0};
		backtrack(question, 0, 0, 0, needScore, res);
		return res[0];
	}

	private static void backtrack(int[] question, int index, int curErrorCnt, int curScore, int needScore, int[] res) {
		if (curScore == needScore) {
			res[0]++;
			return;
		}
		if (index == question.length || curErrorCnt >= 3) {
			return;
		}
		backtrack(question, index + 1, curErrorCnt, curScore + question[index], needScore, res);
		backtrack(question, index + 1, curErrorCnt + 1, curScore, needScore, res);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();

		int res = answerCnt(score);
		System.out.println(res);
	}

}
