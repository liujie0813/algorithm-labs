package com.timberliu.algorithm.company.hw.logic.no003_1_resortStrings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3. 字符串重新排序
 *
 *   A. 单词内部按字典序排序
 *   B. 单词间
 *      a. 按单词出现次数，降序排列
 *      b. 次数相同，按单词长度升序排列
 *      c. 次数和长度相同，按单词升序排列
 *
 * @author Timber
 * @date 2023/3/21
 */
public class Solution1 {

	public static String resortString(String str) {
		String[] strs = str.split(" ");

		Map<String, Integer> strCntMap = new HashMap<>();
		for (String subStr : strs) {
			char[] chars = subStr.toCharArray();
			Arrays.sort(chars);
			String newStr = new String(chars);
			strCntMap.put(newStr, strCntMap.getOrDefault(newStr, 0) + 1);
		}

		List<Map.Entry<String, Integer>> entryList = strCntMap.entrySet().stream().sorted(Comparator.comparing(a -> a, (a, b) -> {
			// 次数相同
			if (a.getValue().equals(b.getValue())) {
				// 长度相同
				if (a.getKey().length() == b.getKey().length()) {
					// 按字典序升序
					return a.getKey().compareTo(b.getKey());
				}
				// 按长度升序
				return a.getKey().length() - b.getKey().length();
			}
			// 按次数降序排序
			return b.getValue().compareTo(a.getValue());
		})).collect(Collectors.toList());

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < entryList.size(); i++) {
			Map.Entry<String, Integer> entry = entryList.get(i);
			for (int j = 0; j < entry.getValue(); j++) {
				res.append(entry.getKey());
				if (j != entry.getValue() - 1) {
					res.append(" ");
				}
			}
			if (i != entryList.size() - 1) {
				res.append(" ");
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String res1 = resortString("My sister is in the house not in the yard");
		System.out.println(res1);

		String res2 = resortString("This is an apple");
		System.out.println(res2);
	}

}
