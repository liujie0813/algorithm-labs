package com.timberliu.algorithm.basic.graph.weightd.graph;

import com.timberliu.algorithm.basic.union.find.WeightedQuickUnionUF;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Kruskal 算法
 *   按照边的权重顺序处理，将边加入到最小生成树中，加入的边不会与已经加入的边构成环，直到 v-1 条边为止
 *
 *   最坏情况下：
 *      时间：O(ElogE)
 *      空间：O(E)
 *
 * @author liujie
 * @date 2021/9/14
 */

public class KruskalMST {

	private Deque<Edge> mst;

	public KruskalMST(WeightedGraph weightedGraph) {
		mst = new LinkedList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>(Edge::compareTo);
		for (Edge edge : weightedGraph.edges()) {
			pq.offer(edge);
		}

		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(weightedGraph.vertexCount());
		while (!pq.isEmpty() && mst.size() < weightedGraph.vertexCount() - 1) {
			Edge edge = pq.poll();
			int v = edge.either();
			int w = edge.other(v);
			if (weightedQuickUnionUF.isConnected(v, w)) {
				continue;
			}
			weightedQuickUnionUF.union(v, w);
			mst.offer(edge);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1 --> 2
		 *     /  |     | \
		 *    /   |     |  \
		 *   <    >     >   >
		 *  4 <-- 3 --> 5 -- > 6
		 */
		WeightedGraph weightedGraph = new WeightedGraph(7);
		weightedGraph.addEdge(new Edge(0, 1, 0.45));
		weightedGraph.addEdge(new Edge(1, 2, 0.49));
		weightedGraph.addEdge(new Edge(1, 3, 0.55));
		weightedGraph.addEdge(new Edge(1, 4, 0.32));
		weightedGraph.addEdge(new Edge(2, 5, 0.40));
		weightedGraph.addEdge(new Edge(2, 6, 0.20));
		weightedGraph.addEdge(new Edge(5, 6, 0.59));
		weightedGraph.addEdge(new Edge(3, 4, 0.35));
		weightedGraph.addEdge(new Edge(3, 5, 0.72));

		KruskalMST kruskalMST = new KruskalMST(weightedGraph);
		for (Edge edge : kruskalMST.edges()) {
			System.out.println(edge);
		}
	}
}
