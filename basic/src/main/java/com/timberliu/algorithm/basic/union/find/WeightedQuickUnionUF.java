package com.timberliu.algorithm.basic.union.find;

/**
 * 加权 quick-union
 *    添加一个数组：记录树中的节点，
 *    union 时，将小树连接到大树的根节点上
 *
 * @author liujie
 * @date 2021/9/15
 */

public class WeightedQuickUnionUF extends AbstractUF {

	private int[] sz;

	public WeightedQuickUnionUF(int N) {
		super(N);
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
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
		if (sz[pId] < sz[qId]) {
			id[pId] = qId;
			sz[qId] += sz[pId];
		} else {
			id[qId] = pId;
			sz[pId] += sz[qId];
		}
		count--;
	}


}
