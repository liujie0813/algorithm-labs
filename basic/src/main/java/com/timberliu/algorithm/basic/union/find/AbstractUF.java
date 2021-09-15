package com.timberliu.algorithm.basic.union.find;

/**
 * 并查集 抽象类
 *    解决动态连通性问题
 *
 * @author liujie
 * @date 2021/9/15
 */

public abstract class AbstractUF {

	protected int[] id;
	protected int count;

	public AbstractUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	// 查找根触点，即指向它自己
	public abstract int find(int p);

	public abstract void union(int p, int q);

}
