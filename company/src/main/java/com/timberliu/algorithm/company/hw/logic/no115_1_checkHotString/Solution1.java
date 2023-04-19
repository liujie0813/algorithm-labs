package com.timberliu.algorithm.company.hw.no115_1_checkHotString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 115. 检测热点字符
 *
 * @author liujie
 * @date 2023/4/12
 */

public class Solution1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		String str = scanner.next();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i += m) {
			// 每 m 个统计一个次数
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j + i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
			// 先按次数倒排序，再按字符倒排序
			List<Character> list = map.entrySet().stream().sorted(Comparator.comparing(a -> a, (a, b) -> {
				if (a.getValue().equals(b.getValue())) {
					return b.getKey().compareTo(a.getKey());
				}
				return b.getValue().compareTo(a.getValue());
			})).map(Map.Entry::getKey).collect(Collectors.toList());
			// 输出前 j 个字符
			for (int j = 0; j < list.size() && j < n; j++) {
				System.out.print(list.get(j));
			}
		}
	}

}
