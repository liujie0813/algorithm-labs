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

public class Solution2 {

	public int[] inventoryManagement(int[] stock, int cnt) {
		heapSort(stock, cnt);
		int[] res = new int[cnt];
		System.arraycopy(stock, 0, res, 0, cnt);
		return res;
	}

	public void heapSort(int[] stock, int cnt) {
		int n = stock.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			sink(stock, i, n);
		}
		for (int i = 0; i < stock.length; i++) {
			swap(stock, 0, n);
			sink(stock, 0, --n);
		}
	}

	private void sink(int[] stock, int k, int n) {
		while (k * 2 + 1 <= n) {
			int j = k * 2 + 1;
			while (j + 1 <= n && stock[j] < stock[j + 1]) {
				j++;
			}
			if (stock[k] > stock[j]) {
				break;
			}
			swap(stock, k, j);
			k = j;
		}
	}

	private void swap(int[] stock, int i, int j) {
		int tmp = stock[i];
		stock[i] = stock[j];
		stock[j] = tmp;
	}

	public static void main(String[] args) {
		Solution2 solution1 = new Solution2();
		int[] rees = solution1.inventoryManagement(new int[]{0,0,1,0,3,2,6,1,0,7,3,2,10,11,1,2,3,15,11,16,5,17,2,4,24,20}, 10);
		System.out.println(Arrays.toString(rees));

	}

}
