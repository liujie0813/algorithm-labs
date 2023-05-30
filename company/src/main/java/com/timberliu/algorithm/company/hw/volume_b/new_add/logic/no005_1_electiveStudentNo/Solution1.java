package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no005_1_electiveStudentNo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 5. 选修课
 *
 * @author liujie
 * @date 2023/5/23
 */

public class Solution1 {

	public static String electiveStudentNo(List<String[]> first, List<String[]> second) {
		Map<String, Integer> map = new HashMap<>();
		for (String[] strs : first) {
			map.put(strs[0], Integer.parseInt(strs[1]));
		}
		PriorityQueue<String[]> pq = new PriorityQueue<String[]>((a, b) -> {
			String firstClass = a[0].substring(0, 5);
			String secondClass = b[0].substring(0, 5);
			if (firstClass.equals(secondClass)) {
				int firstScore = Integer.parseInt(a[1]);
				int secondScore = Integer.parseInt(b[1]);
				if (firstScore == secondScore) {
					return a[0].compareTo(b[0]);
				}
				return secondScore - firstScore;
			}
			return firstClass.compareTo(secondClass);
		});
		for (String[] strs : second) {
			if (map.containsKey(strs[0])) {
				pq.offer(new String[]{strs[0], map.get(strs[0]) + strs[1]});
			}
		}
		TreeMap<String, List<String>> treeMap = new TreeMap<>();
		while (!pq.isEmpty()) {
			String[] poll = pq.poll();
			String class1 = poll[0].substring(0, 5);
			List<String> list = treeMap.computeIfAbsent(class1, (key) -> new ArrayList<>());
			list.add(poll[0]);
		}
		StringBuilder res = new StringBuilder();
		for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
			res.append(entry.getKey()).append("\n");
			List<String> list = entry.getValue();
			for (int i = 0; i < list.size(); i++) {
				res.append(list.get(i));
				if (i == list.size() - 1) {
					res.append("\n");
				} else {
					res.append(";");
				}
			}
		}
		return res.length() == 0 ? "NULL" : res.toString();
	}

	/*
	 * 01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
	 * 01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
	 */
	/**
	 * 01202022,75;01201033,95;01202018,80;01203006,90;01202066,100
	 * 01202008,70;01203102,85;01202111,80;01202021,75;01201100,88
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		String[] firstSplits = firstLine.split(";");
		List<String[]> first = Arrays.stream(firstSplits).map(str -> str.split(",")).collect(Collectors.toList());

		String secondLine = scanner.nextLine();
		String[] secondSplits = secondLine.split(";");
		List<String[]> second = Arrays.stream(secondSplits).map(str -> str.split(",")).collect(Collectors.toList());

		String res = electiveStudentNo(first, second);
		System.out.println(res);
	}

}
