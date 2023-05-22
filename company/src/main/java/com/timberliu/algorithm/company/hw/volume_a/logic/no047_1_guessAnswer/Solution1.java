package com.timberliu.algorithm.company.hw.volume_a.logic.no047_1_guessAnswer;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 47. 猜字谜
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static List<String> guess(String[] questions, String[] answers) {
		// 一个谜面对应一个谜底
		// 如果对应多个，就要用 Map<String, List<String>>
		Map<String, String> answerMap = new HashMap<>();
		for (String answer : answers) {
			answerMap.put(distinctAndSort(answer), answer);
		}

		List<String> res = new ArrayList<>();
		for (String question : questions) {
			String newQuestion = distinctAndSort(question);
			res.add(answerMap.getOrDefault(newQuestion, "not found"));
		}
		return res;
	}

	private static String distinctAndSort(String str) {
		TreeSet<Character> set = new TreeSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		return set.toString();
	}

	/**
	 * bdni,woooood
	 * bind,wrong,wood
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] questions = scanner.nextLine().split(",");
		String[] answers = scanner.nextLine().split(",");
		List<String> res = guess(questions, answers);
		PrintUtils.printListString(res);
	}

}
