package com.timberliu.algorithm.basic.graph.weightd.graph;

/**
 * 边
 *
 * @author liujie
 * @date 2021/9/14
 */

public class Edge implements Comparable<Edge> {

	private final int vertex;

	private final int another;

	private final double weight;

	public Edge(int vertex, int another, double weight) {
		this.vertex = vertex;
		this.another = another;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int either() {
		return vertex;
	}

	public int other(int v) {
		if (this.vertex == v) {
			return this.another;
		} else if (this.another == v) {
			return this.vertex;
		} else {
			return -1;
		}
	}

	@Override
	public int compareTo(Edge o) {
		if (this.weight < o.weight) {
			return -1;
		} else if (this.weight > o.weight) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.format("%d-%d %.2f", vertex, another, weight);
	}
}
