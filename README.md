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