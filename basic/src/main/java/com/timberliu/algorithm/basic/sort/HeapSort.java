package com.timberliu.algorithm.basic.sort;

import java.util.Arrays;

/**
 * 堆：根节点大于等于（小于等于）子节点
 *
 *  建堆：从第一个非空叶子节点，开始下沉操作
 *     从小到大排序，即建大顶堆
 *  排序：类似堆的删除操作，把堆顶元素放到数组最后一个位置表示排好序
 *       把数组最后一个位置交换到堆顶，维护堆
 *
 * @author liujie
 * @date 2024/6/3
 */

public class HeapSort {

	public void heapSort(int[] arr) {
		int len = arr.length - 1;
		// 建堆
		for (int k = (len - 1) / 2; k >= 0; k--) {
			sink(arr, k, len);
		}
		// 排序
		while(len > 0) {
			swap(arr, 0, len--);
			sink(arr, 0, len);
		}
	}

	// k元素下沉到合适位置
	private void sink(int[] arr, int k, int len) {
		// k的子节点 小于等于 n
		while (k * 2 + 1 <= len) {
			// 左子节点
			int j = k * 2 + 1;
			if (j + 1 <= len && arr[j] < arr[j + 1]) {
				// 考虑右子节点
				j++;
			}
			if (arr[k] > arr[j]) {
				break;
			}
			swap(arr, k, j);
			k = j;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int[] arr = {1, 7, 3, 8, 5, 4, 6, 2, 9};
		heapSort.heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
