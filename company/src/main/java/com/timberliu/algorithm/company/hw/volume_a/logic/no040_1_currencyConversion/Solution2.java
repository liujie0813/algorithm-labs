package com.timberliu.algorithm.company.hw.volume_a.logic.no040_1_currencyConversion;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 40. 货币单位运算
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution2 {

	public static Pattern pattern = Pattern.compile("(\\d+)([a-zA-Z]+)");

	public static int currencyConversion(String[] arr) {
		double res = 0;
		for (String str : arr) {
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				String amount = matcher.group(1);
				String unit = matcher.group(2);
				res += getVal(amount, unit);
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
