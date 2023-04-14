package com.timberliu.algorithm.basic.binarysearch;

/**
 * @author liujie
 * @date 2023/4/14
 */

public class ThreeSearch {

	public static double threeSearch(double left, double right) {
		double eps = 0.00001;
		while (right - left >= eps) {
			double diff = (right - left) / 3;
			double first = left + diff;
			double second = right - diff;
			if (f(first) < f(second)) {
				left = first;
			} else {
				right = second;
			}
		}
		return left;
	}

	public static double f(double x) {
		return -x * x;
	}

	public static void main(String[] args) {
		double res = threeSearch(-100, 10);
		System.out.println(res);
	}

}
