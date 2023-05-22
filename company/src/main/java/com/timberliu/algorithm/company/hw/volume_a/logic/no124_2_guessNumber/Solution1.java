package com.timberliu.algorithm.company.hw.volume_a.logic.no124_2_guessNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 124. 猜数字
 *
 * @author Timber
 * @date 2023/5/4
 */
public class Solution1 {

	public static String guessNumber(String[][] arr, int n) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						String guess = i + j + k + l + "";
						if (check(guess, arr)) {
							res.add(guess);
						}
					}
				}
			}
		}
		if (res.size() == 1) {
			return res.get(0);
		} else {
			return "NA";
		}
	}

	private static boolean check(String guess, String[][] inputs) {
		for (String[] input : inputs) {
			if (!input[1].equals(check(input[0], guess))) {
				return false;
			}
		}
		return true;
	}

	private static String check(String input, String guess) {
		int correct = 0;
		int[] inputMap = new int[10];
		int[] guessMap = new int[10];
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == guess.charAt(i)) {
				correct++;
			} else {
				inputMap[input.charAt(i) - '0']++;
				guessMap[guess.charAt(i) - '0']++;
			}
		}
		int half = 0;
		for (int i = 0; i < 10; i++) {
			half += Math.min(inputMap[i], guessMap[i]);
		}
		return correct + "A" + half + "B";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[][] arr = new String[n][2];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextLine().split(" ");
		}

		String res = guessNumber(arr, n);
		System.out.println(res);
	}

}
