package com.timberliu.algorithm.basic.binarysearch;

/**
 * @author liujie
 * @date 2024/7/3
 */

public class FirstGreaterOrEqualsTarget {

	public static int nextGreatestOrEqualsLetter(char[] letters, char target) {
		int left = 0, right = letters.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (letters[mid] < target) {
				left = mid + 1;
			} else {
				if (mid == left || letters[mid - 1] < target) {
					return mid;
				} else {
					right = mid;
				}
			}
		}
		return -1;
	}

	public static int nextGreatestOrEqualsLetter2(char[] letters, char target) {
		int left = 0, right = letters.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (letters[mid] < target) {
				left = mid + 1;
			} else {
				if (mid == left || letters[mid - 1] < target) {
					return mid;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(nextGreatestOrEqualsLetter2(new char[]{'a', 'b', 'b', 'c', 'd', 'e'}, 'b'));

		System.out.println(nextGreatestOrEqualsLetter2(new char[]{'a', 'c', 'd', 'e'}, 'b'));
	}

}
