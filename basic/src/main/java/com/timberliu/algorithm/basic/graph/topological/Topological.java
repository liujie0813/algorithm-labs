package com.timberliu.algorithm.basic.graph.topological;

import com.timberliu.algorithm.basic.graph.digraph.DepthFirstOrder;
import com.timberliu.algorithm.basic.graph.digraph.Digraph;
import com.timberliu.algorithm.basic.graph.digraph.DirectedCycle;

import java.util.Deque;

/**
 * 拓扑排序
 *
 *   1. 必须是有向无环图
 *   2. 深度优先 后序遍历的 逆序即为拓扑排序的结果
 *
 * @author liujie
 * @date 2021/9/14
 */

public class Topological {

	private Deque<Integer> order;

	public Topological(Digraph digraph) {
		DirectedCycle directedCycle = new DirectedCycle(digraph);
		if (!directedCycle.hasCycle()) {
			DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
			order = depthFirstOrder.reversePost();
		}
	}

	public Deque<Integer> order() {
		return order;
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1 --> 3
		 *        |     |
		 *        |     |
		 *        >     >
		 *  5 <-- 2 <-- 4
		 */
		Digraph digraph = new Digraph(6);
		digraph.addEdge(0, 1);
		digraph.addEdge(1, 2);
		digraph.addEdge(1, 3);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 2);
		digraph.addEdge(2, 5);

		Topological topological = new Topological(digraph);
		Deque<Integer> order = topological.order();
		while (!order.isEmpty()) {
			System.out.print(order.pop() + " -> ");
		}
	}
}
