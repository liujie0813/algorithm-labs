package com.timberliu.algorithm.basic.union.find;

/**
 * 路径压缩 quick-union
 *
 *    find：路径压缩，将 id[p] 指向 id[p] 的根节点
 *
 * @author liujie
 * @date 2021/9/15
 */

public class PathCompressionWeightedQuickUnionUF extends AbstractUF {

	private int[] rank;

	public PathCompressionWeightedQuickUnionUF(int N) {
		super(N);
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = 1;
		}
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			id[p] = find(id[p]);
		}
		return p;
	}

	@Override
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			return;
		}
		if (rank[pId] < rank[qId]) {
			id[pId] = qId;
		} else if (rank[qId] < rank[pId]) {
			id[qId] = pId;
		} else {
			id[pId] = qId;
			rank[qId]++;
		}
		count--;
	}

}
