package com.timberliu.algorithm.company.hw.volume_a.logic.no073_1_exceptionRecord;

import java.util.*;

/**
 * 73. 异常的打卡记录
 *
 * @author Timber
 * @date 2023/4/22
 */
public class Solution1 {

	public static String findExceptionRecords(String[] records, int n) {
		Map<String, List<String[]>> map = new HashMap<>();
		Set<Integer> exceptionRecords = new TreeSet<>();
		for (int i = 0; i < records.length; i++) {
			String[] strs = records[i].split(",");
			if (!strs[3].equals(strs[4])) {
				exceptionRecords.add(i);
			}

			String[] newStrs = Arrays.copyOf(strs, strs.length + 1);
			newStrs[5] = i + "";
			List<String[]> list = map.computeIfAbsent(strs[0], (val) -> new ArrayList<>());
			list.add(newStrs);
		}

		for (List<String[]> list : map.values()) {
			list.sort(Comparator.comparingInt(a -> Integer.parseInt(a[1])));

			for (int i = 0; i < list.size(); i++) {
				int time1 = Integer.parseInt(list.get(i)[1]);
				int distance1 = Integer.parseInt(list.get(i)[2]);
				for (int j = i + 1; j < list.size(); j++) {
					int time2 = Integer.parseInt(list.get(j)[1]);
					int distance2 = Integer.parseInt(list.get(j)[2]);
					if (time2 - time1 >= 60) {
						break;
					} else if (Math.abs(distance2 - distance1) > 5) {
						exceptionRecords.add(Integer.parseInt(list.get(i)[5]));
						exceptionRecords.add(Integer.parseInt(list.get(j)[5]));
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int index : exceptionRecords) {
			sb.append(records[index]).append(";");
		}
		return sb.length() == 0 ? "null" : sb.deleteCharAt(sb.length() - 1).toString();
	}

	/*
	 * 2
	 * 100000,10,1,ABCD,ABCD
	 * 100001,80,10,ABCD,ABCD
	 */
	/**
	 * 2
	 * 100000,10,1,ABCD,ABCD
	 * 100000,50,10,ABCD,ABCD
	 */
	/*
	 * 3
	 * 100000,10,1,ABCD,ABCD
	 * 100000,80,10,ABCD,ABCD
	 * 100000,90,11,ABCD,ABCD
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] records = new String[n];
		for (int i = 0; i < n; i++) {
			records[i] = scanner.nextLine();
		}

		String res = findExceptionRecords(records, n);
		System.out.println(res);
	}

}
