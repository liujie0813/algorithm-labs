## leetcode

重点：
- program：纯编程类
- array：数组
- linkedlist：链表
- stask_queue：栈、队列
- recursion：递归
- sort：排序
- binary_search：二分查找
- hashtable：哈希表
- string：字符串
- tree：树
- bst：二分搜索树
- bfs&dfs：宽度&深度
- dp：动态规划
- 回溯

题型：
- 单调栈
- 双指针、滑动窗口
- 前缀后缀统计
- 位运算
- 海量数据处理

其他：
- 字符串匹配
- 图相关算法
- 跳表
- 并查集
- Trie
- 贪心


## 数组

**二分查找**

注意区间的定义：
- 左闭右闭 [left, right]
- 左闭右开 [left, right)

**双指针法**

通过快慢指针在一个 for 循环内完成两个循环的工作

**滑动窗口**

根据当前子序列和大小的情况，不断调节子序列的起始位置。

**模拟行为**

注意边界情况。

## 字符串

**双指针法**

反转单个字符串，使用双指针，一个指针从前往后，另一个指针从后往前。

反转字符串里的单词、左旋转字符串，主要思路就是先整体反转，再局部反转。

**KMP**

## 回溯

回溯的本质是穷举。可能有剪枝。

- 组合问题：77、17、39、40、216
- 切割问题：131、93
- 子集问题：78、90
- 排列问题：46、47
- 棋盘问题：N皇后 51、数独 37

组合问题和切割问题都是收集树的叶子节点，而子集问题是收集树的所有节点（一般不需要剪枝）

排列问题的不同：
- 每层是从 0 开始遍历，而不是 startIndex；
- 需要 used 数组记录 path 里都存放了哪些元素；

模板：

```
void backtracking(参数) {
	if (终止条件) {
	    存放结果
	    return;
	}
	for (选择: 本层集合中元素(树中节点孩子的数量就是集合大小) ) {
	    处理节点
	    backtracking(路径, 选择列表); // 递归
	    回溯，撤销处理结果    
	}
}
```

## 贪心

贪心的本质是选择每个阶段的最优解，从而达到全局最优。

如何验证可不可以用贪心？最好的策略就是举反例，如果想不到，就可以尝试一下贪心。

- 简单：455、1005、860
- 中等：
  - 序列问题：376、738
  - 股票问题：122、714
  - 两个维度权衡：135、406
    - 两个维度相互影响时，一般都要先确定一个维度，再考虑另一个维度
- 困难：
  - 区间：55、45、452、435、763、56
    - 区间问题一般都要排序（扫描线）；再考虑覆盖、去重等；
  - 53、134、968

## DP

### 理论基础

贪心是局部选取最优解；动态规划是每个状态由前一个状态推导出来的。

五步曲：
- 确定 dp 数组及下标的含义
- 确定递推公式
- dp 数组如何初始化
- 确定遍历顺序
- 举例推导 dp 数组

如何 debug？把 dp 数组打印出来，看是否是按照自己的思路推导的。

### 基础题目

### 背包问题

### 股票问题

### 子序列问题

### 打家劫舍