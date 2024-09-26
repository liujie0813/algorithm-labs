package com.timberliu.algorithm.leetcode.sort.no0215_2_kthLargestElementInAnArray.related.lcr_no0159_1_inventoryManagement;

import java.util.Arrays;

/**
 * LCR159. 库存管理
 *
 * topK 元素
 * 1. 快速排序
 * 	切分：
 * 		a. 切分 partition 等于 k 时返回；
 * 		b. 切分 partition 大于 k 时，在 partition-1 左半部分查找 k
 * 		c. 切分 partition 小于 k 时，在 partition+1 右半部分查找 k
 * 2. 堆排序
 * 		a. 建堆
 * 		b. 交换-排序，交换到第 k 个元素时返回
 *
 * @author liujie
 * @date 2024/9/25
 */

public class Solution1 {

	public int[] inventoryManagement(int[] stock, int cnt) {
		inventoryManagement(stock, 0, stock.length - 1, cnt - 1);
		int[] res = new int[cnt];
		System.arraycopy(stock, 0, res, 0, cnt);
		return res;
	}

	private int inventoryManagement(int[] stock, int left, int right, int index) {
		int p = partition(stock, left, right);
		if (p == index) {
			return p;
		} else if (p > index) {
			return inventoryManagement(stock, left, p - 1, index);
		} else {
			return inventoryManagement(stock, p + 1, right, index);
		}
	}

	private int partition(int[] stock, int left, int right) {
		int pivot = stock[left];
		int i = left, j = right + 1;
		while (i <= j) {
			while (i < right && stock[++i] < pivot) {
			}
			while (j > left && stock[--j] > pivot) {
			}
			if (i >= j) {
				break;
			}
			int tmp = stock[i];
			stock[i] = stock[j];
			stock[j] = tmp;
		}
		stock[left] = stock[j];
		stock[j] = pivot;
		return j;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[] rees = solution1.inventoryManagement(new int[]{0, 4, 3, 2, 6, 1}, 3);
		System.out.println(Arrays.toString(rees));

	}

}
