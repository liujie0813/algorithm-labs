package com.timberliu.algorithm.basic.union.find;

/**
 * quick-find
 *   保证同一连通分量中触点的值相同
 *
 * @author liujie
 * @date 2021/9/15
 */

public class QuickFindUF extends AbstractUF {

	public QuickFindUF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
		count--;
	}
}
