package com.timberliu.algorithm.basic.api;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujie
 * @date 2023/4/11
 */

public class Api {

	public static void main(String[] args) {
		int[] arr1 = {1, 9, 2, 5, 3, 6, 4};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));

		int[][] arr2 = new int[][]{
				{1, 5},
				{2, 3},
				{1, 3}
		};
		Arrays.sort(arr2, Comparator.comparing(a -> a[0]));
		System.out.println(Arrays.deepToString(arr2));

		int[][] arr3 = new int[][]{
				{1, 5},
				{2, 3},
				{1, 3}
		};
		Arrays.sort(arr3, Comparator.comparing(a -> a, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		}));
		System.out.println(Arrays.deepToString(arr3));

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 3, 2, 4));
		list1.sort(Comparator.naturalOrder());
		System.out.println(Arrays.toString(list1.toArray()));

		Map<Integer, List<Integer>> map1 = new HashMap<>();
		List<Integer> subList1 = map1.computeIfAbsent(123, (val) -> new ArrayList<>());
		subList1.add(2);

		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 3);
		map.put("c", 7);
		map.put("d", 3);
		List<Map.Entry<String, Integer>> list = map.entrySet().stream().sorted(Comparator.comparing(a -> a, (a, b) -> {
			if (a.getValue().equals(b.getValue())) {
				return b.getKey().compareTo(a.getKey());
			}
			return b.getValue().compareTo(a.getValue());
		})).collect(Collectors.toList());

	}

}
