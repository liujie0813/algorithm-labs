package com.timberliu.algorithm.company.hw.logic.no040_1_currencyConversion;

import java.util.Scanner;

/**
 * 40. 货币单位运算
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static int currencyConversion(String[] arr) {
		double res = 0;
		for (String str : arr) {
			StringBuilder digit = new StringBuilder();
			StringBuilder currency = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (Character.isDigit(ch)) {
					digit.append(ch);
				} else if (Character.isLetter(ch)) {
					currency.append(ch);
				}
				if (Character.isLetter(ch) && (i + 1 == str.length() || Character.isDigit(str.charAt(i + 1)))) {
					res += getVal(digit.toString(), currency.toString());
					digit = new StringBuilder();
					currency = new StringBuilder();
				}
			}
		}
		return (int) res;
	}

	private static double getVal(String digit, String currency) {
		int val = Integer.parseInt(digit);
		switch (currency) {
			case "CNY": return val * 100;
			case "fen": return val;
			case "JPY": return val * 10000.0 / 1825;
			case "sen": return val * 100.0 / 1825;
			case "HKD": return val * 10000.0 / 123;
			case "cents": return val * 100.0 / 123;
			case "EUR": return val * 10000.0 / 14;
			case "eurocents": return val * 100.0 / 14;
			case "GBP": return val * 10000.0 / 12;
			case "pence": return val * 100.0 / 12;
			default: break;
		}
		return 0;
	}

	/**
	 * 2
	 * 20CNY53fen
	 * 53HKD87cents
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = scanner.nextLine();
		}

		int res = currencyConversion(str);
		System.out.println(res);
	}

}
