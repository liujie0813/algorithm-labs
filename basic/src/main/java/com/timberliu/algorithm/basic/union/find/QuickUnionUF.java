package com.timberliu.algorithm.basic.union.find;

/**
 * quick-union
 *    find：返回根触点，即指向它自己
 *    union：将一个树链接到另一个树的根节点上
 *
 * @author liujie
 * @date 2021/9/15
 */

public class QuickUnionUF extends AbstractUF {

	public QuickUnionUF(int N) {
		super(N);
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
		id[pId] = qId;
		count--;
	}


}
