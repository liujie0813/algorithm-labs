package com.timberliu.algorithm.company.hw.volume_b.logic.new_no999_1_alarmList;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 告警抑制
 *
 * @author liujie
 * @date 2023/5/24
 */

public class Solution1 {

	public static List<String> alarmList(String[] arr, String[][] control) {
		Map<String, Set<String>> map = new HashMap<>();
		for (String[] strs : control) {
			Set<String> set = map.computeIfAbsent(strs[1], (key) -> new HashSet<>());
			set.add(strs[0]);
		}

		Set<String> alarmSet = new HashSet<>();
		List<String> res = new ArrayList<>();
		for (String alarm : arr) {
			// 没有可以抑制 alarm 的更高等级的告警
			// 或者没有在告警列表中出现
			if (!map.containsKey(alarm) || !Collections.disjoint(map.get(alarm), alarmSet)) {
				res.add(alarm);
			}
			alarmSet.add(alarm);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[][] controlRelation = new String[n][2];
		for (int i = 0; i < n; i++) {
			String[] splits = scanner.nextLine().split(" ");
			controlRelation[i] = splits;
		}
		String[] arr = scanner.nextLine().split(" ");

		List<String> res = alarmList(arr, controlRelation);
		PrintUtils.printListString(res);

	}

}
