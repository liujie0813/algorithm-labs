package com.timberliu.algorithm.leetcode.array.slide_window.no0904_2_fruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 *
 * Created by liujie on 2021/2/25
 */
public class Solution1 {

    public static int totalFruit(int[] fruits) {
    	int res = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		for (int right = 0; right < fruits.length; right++) {
			// 统计每种水果出现次数
			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
			while (map.size() > 2) {
				map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
				if (map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}
			res = Math.max(right - left + 1, res);
		}
		return res;
    }

    public static void main(String[] args) {
		int res = totalFruit(new int[]{});
		System.out.println(res);
	}

}