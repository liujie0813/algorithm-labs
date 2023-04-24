# leetcode

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


# 数组

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

# 字符串

**双指针法**

反转单个字符串，使用双指针，一个指针从前往后，另一个指针从后往前。

反转字符串里的单词、左旋转字符串，主要思路就是先整体反转，再局部反转。

**KMP**

# 回溯

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

# 贪心

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

# DP

## 理论基础

贪心是局部选取最优解；动态规划是每个状态由前一个状态推导出来的。

五步曲：
- 确定 dp 数组及下标的含义
- 确定递推公式
- dp 数组如何初始化
- 确定遍历顺序
- 举例推导 dp 数组

如何 debug？把 dp 数组打印出来，看是否是按照自己的思路推导的。

## 基础题目

- 斐波那契：509、70、746
- 整数拆分：343
- 不同的二分搜索树：96

## 背包问题

背包问题：
- 背包：最大容量 v
- 物品：
  - 价值 w
  - 体积 v
  - 每个物品的数量

根据每个物品的数量又分为：
- 01 背包：每个物品只有一个
- 完全背包：每个物品有无数个
- 多重背包：不同的物品数量不同

### 01 背包

**普通解法**

定义：dp[i][j]，考虑前 i 个物品 [0, i]，放到容量为 j 的背包里，最大价值

推导，有两个方向：
- 不放物品 i：dp[i - 1][j]
- 放物品 i：dp[i - 1][j - weight[i]] + value[i]

状态转移方程：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weigh[i]] + value[i])

初始化：
- dp[i][0]：容量为 0 时，最大价值一定为 0；
- dp[0][j]：考虑第 0 个物品，如果 weight[0] 小于等于 capacity，则最大价值为 value[0]；

```java
public static int maxValue(int capacity, int[] weight, int[] value) {
    int n = weight.length;
    int[][] dp = new int[n][capacity + 1];
    for (int j = weight[0]; j <= capacity; j++) {
        dp[0][j] = value[0];
    }
    // 二维 dp 数组的两个 for 循环的先后顺序是可以颠倒的
    // 遍历物品
    for (int i = 1; i < n; i++) {
        // 遍历背包容量
        for (int j = 0; j <= capacity; j++) {
            if (j < weight[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
    }
    return dp[n-1][capacity];
}
```

**滚动数组，空间优化**

滚动数组：上一层的结果可以重复利用，直接拷贝到当前层。

dp[j]：表示容量为 j 的背包，物品的最大价值和

推导：
- 不放物品 i：dp[j]，相当于二维数组中的 dp[i-1][j]
- 放物品 i：dp[j - weight[i]] + value[i]

状态转移方程：dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i])

初始化：
- dp[0] = 0：背包容量为 0 时，最大价值一定为 0；
- dp[i]：由于 dp 数组在推导时都是取最大值，初始化为 0 就好

遍历顺序：
- 一维 dp 遍历时，背包容量是从大到小

dp[j] 由 dp[j - weight[i]] 推导而来：
- 如果使用正序遍历，在计算 dp[j] 时，dp[j - weight[i]] 已经被本层的结果覆盖了。对应到二维数组，就是取的是本层 dp[i][j-weight[i]] 的结果，但实际上应该取 dp[i-1][j-weight[i]]。 
- 但如果使用倒序遍历，在计算 dp[j] 时，dp[j - weight[i]] 还是上一层的结果，还未被覆盖

```java
public static int maxValue1(int capacity, int[] weight, int[] value) {
    int n = weight.length;
    int[] dp = new int[capacity + 1];
    // 一维 dp 数组的两个 for 循环一定是先遍历物品，再遍历容量
    // 遍历物品
    for (int i = 0; i < n; i++) {
        // 需要倒序遍历
        for (int j = capacity; j >= weight[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
    }
    return dp[capacity];
}
```

**应用**

- 01 背包：给定背包容量，装满背包的最大价值是多少
- 416 分割等和子集：给定背包容量，能不能刚好装满背包
- 1049 最后一块石头的重量 II：给定背包，尽可能装，最多能装多少
- 494 目标和：给定背包容量，装满背包有多少种方案
- 474 一和零：给定背包容量，装满背包最多有多少个物品
  - 仍是 01 背包问题，只不过物品重量有两个维度；多重背包是每个物品，数量不同的情况；

### 完全背包

完全背包与 01 背包唯一不同的地方就在于：每件物品有无限个。

**二维 dp 数组解法**

状态转移方程： dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i]] + k * value[i]), 0 < k * weight[i] <= j

```java
public static int maxValue(int capacity, int[] weight, int[] value) {
    int n = weight.length;
    int[][] dp = new int[n + 1][capacity + 1];
    // 第一件物品
    for (int j = 0; j <= capacity; j++) {
    	// 只要一件物品，容量允许的情况下，能装多少装多少
        dp[0][j] = j / weight[0] * value[0];
    }

    // 先遍历物品
    for (int i = 1; i < n; i++) {
    	// 再遍历容量
        for (int j = 0; j <= capacity; j++) {
            // 第 i 件物品，能装多少
            int tmp = 0;
            for (int k = 1; k * weight[i] <= j; k++) {
                tmp = Math.max(tmp, dp[i - 1][j - k * weight[i]] + k * value[i]);
            }
            dp[i][j] = Math.max(dp[i - 1][j], tmp);
        }
    }
    return dp[n - 1][capacity];
}
```

**一维空间优化**

二维 dp 数组的 dp[i][j]，依赖于 i-1 行的 dp[i-1][j]、dp[i-1][j - weight[i]]、dp[i-1][j - 2*weight[i]] 等多个值。

在改为一维 dp 数组后，其状态方程为：dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i])

可以理解为：
- dp[j] 对应 dp[i-1][j]
- dp[j-weight[i]] 对应了多个 dp[i-1][j - k\*weight[i]]，由于第 i 行的 dp[j-weight[i]] 已经由第 i-j 行的 dp[i-1][j-2\*weight[i]]、dp[i-1][j-3\*weight[i]] 等计算出来了，所以不用再一一与前面的 dp[j-k*weight[i]] 进行比较。

```java
public static int maxValue1(int capacity, int[] weight, int[] value) {
    int n = weight.length;
    int[] dp = new int[capacity + 1];
    // 遍历物品
    for (int i = 0; i < n; i++) {
        for (int j = weight[i]; j <= capacity; j++) {
            dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
    }
    return dp[capacity];
}
```

对于完全背包，一维 dp 数组的两个 for 循环先后顺序是无所谓的。因为 dp[j] 是依赖 dp[j] 及之前的元素的，而背包容量是从小到大遍历，dp[j] 及之前的元素已经都经过计算了。

**总结**

01 背包和完全背包的一维空间优化解法中，唯一的不同是容量维度 遍历方向从 [从大到小] 改为 [从小到大]。

本质上是因为两者在进行状态转移时，依赖的元素不同：
- 01 背包：依赖的是上一行正上方的元素、上一行左边的元素
  - 二维：依赖上一行左边的元素；一维：依赖当前行左边的元素）
- 完全背包：依赖的是上一行正上方的元素、当前行左边的元素
  - 二维：依赖上一行左边的多个元素；一维：依赖当前行左边的上一个元素（上一个元素也是依赖当前行的上上一个元素，所以仅取上一个就行）

### 多重背包

多重背包与 01 背包的区别就是多重背包中，每件物品的数量不同，有 Mi 件。

```java
public static int maxValue(int[] weight, int[] value, int[] limit, int capacity) {
    int[] dp = new int[capacity + 1];
    for (int i = 0; i < weight.length; i++) {
        for (int j = capacity; j >= weight[i]; j--) {
            // 相比于 01 背包，加一个遍历：物品数量限制
            for (int k = 0; k <= limit[i] && k * weight[i] <= j; k++) {
                dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
            }
        }
    }
    return dp[capacity];
}
```

一维空间优化：
- 三种背包的一维空间优化中，只有完全背包的容量维度是从大到小的；其他两种背包的容量维度都是从小到大的；
- 只有完全背包同时能降低算法的时间复杂度；而其他两种背包只是做单纯的数组滚动操作；

### 另一种角度的总结

常见的背包问题有三类：
- 组合排列问题：
  - 377、组合总和 IV
  - 494、目标和
  - 518、零钱兑换 II
- true/false 问题：
  - 139、单词拆分
  - 416、分割等和子集
- 最大/最小问题：
  - 322、一和零
  - 474、零钱兑换

判断背包问题逻辑：
- 分析是否是背包问题
- 是以上三种背包问题中的哪一种
- 是 01 背包问题还是完全背包问题，也就是题目中的物品是否可以重复使用
- 如果是组合问题，是否需要考虑元素顺序，也就是组合还是排列

状态定义：
- 最大/最小、true/false 问题
  - dp[i][j]：考虑前 i 个物品，放到容量为 j 的背包，最大价值/是否能装满；
- 组合问题
  - dp[i][j]：考虑前 i 个数字，凑成总和为 j 的组合个数（第 i 个数字是否选择，遍历选几次k）
- 排列问题：
  - dp[i][j]：考虑排列长度为 i，凑成总和为 j 的排列个数（最后一个数字可以任意选择，遍历nums数组）

转移公式：
- true、false 问题：dp[j] = dp[j] or dp[j - weight[i]]
- 最大、最小问题：dp[j] = max/min(dp[j], dp[j - weight[i]] + value[i])
- 组合排列问题：dp[j] += dp[j - weight[i]]
  - 二维-组合：
```
dp[i][j] = ∑ dp[i - 1][j - k * val], j >= k * val，val = nums[i]
           k从1到j/val
```
  - 二维-排列：
```
dp[i][j] = ∑ dp[i - 1][j - nums[i]], j >= nums[i]
           i从0到n-1
```

遍历顺序技巧：
- 01 背包，也就是元素不可重复使用：

```java
for (int i = 0; i < weight.length; i++) {
    for (int j = target; j >= weight[i]; j--) {
    }
}
```

- 完全背包，也就是元素可以重复使用（包括组合问题）

```java
for (int i = 0; i < weight.length; i++) {
    for (int j = weight[i]; j <= target; j++) {
    }
}
```

- 排列问题：

```java
for (int i = 0; i <= target; i++) {
    for (int j = 0; j < weight.length; j++) {
    	if (i >= weight[j]) {
        }
    }
}
```

## 路径问题

- 不同路径：62、63

## 股票问题

- 121: 买卖股票 - 只能买卖一次
- 122：可以买卖多次
- 123：至多买卖两次
- 183：最多买卖 k 次
- 309：可以买卖多次 - 含冷冻期
- 714：可以买卖多次 - 有手续费

## 子序列问题

- 递增子序列：300、674
- 公共子序列：718、1035、1143
- 子序列编辑：72、115、392、583
- 回文子串：5、647

区别更多在于状态的定义。

## 打家劫舍

- 198、213、337

## chw

递归、分治、单调栈、并查集、滑动窗口、前缀和、二分、DFS&BFS

题目 | 分值 | 类型 | 说明
--- | --- | --- | ---
44. 计算快递业务主站点 | 200 | 并查集 | 
45. 分奖金 | 200 | 单调栈 | 倒序遍历
46. 整理扑克牌 | 100 | 逻辑分析 | 
47. 猜字谜 | 100 | 逻辑分析 | 
48. 数字加减游戏 | 200 | 数学 | 
49. 优雅子数组 | 200 | 双指针 | 
50. 找出重复代码 | 100 | DP | 最长公共子串
51. 密室逃生游戏 | 100 | 逻辑分析 | 
52. 匿名信 | 100 | 逻辑分析 | 
53. 任务调度 | 100 | 优先级队列 | 
54. 寻找路径 | 100 | 树 | 
55. 新学校选址 | 100 | 数学（中位数）| 
56. 机器人 | 100 | DFS/并查集 | 
57. 最大报酬 | 100 | DP（01 背包） | 
58. 通信误码 | 100 | 逻辑分析 | 
59. 开心消消乐 | 100 | 并查集 | 类似岛屿数量
60. 投篮大赛 | 100 | 逻辑分析（栈） | 
61. 开放日活动 | 200 | 二分查找 | 
62. 相同数字的积木游戏 | 100 | 逻辑分析 |
63. Excel 单元格数值统计 | 200 | 逻辑分析（递归） |
64. 二进制差异数 | 200 | 数学 | 
65. 获取最大软件版本号 | 100 | 逻辑分析 | 
66. 简单的自动曝光 | 100 | 逻辑分析 | 
67. 基站维护最短距离 | 200 | 回溯 | 
68. 士兵过河 | 200 | (二分查找+贪心)/DP | 
69. 查找二叉树节点 | 200 | 树 | 层级遍历
70. 硬件产品销售方案 | 100 | 回溯 | 
71. 计算网络信号 | 200 | DFS/BFS | 
72. 核酸最快检测效率 | 200 | 贪心+优先级队列 | 
73. 异常的打卡记录 | 100 | 逻辑分析 | 
74. 删除重复数字后的最大数字 | 200 | 单调栈 | 最大数字：当前元素大于栈顶元素（队尾）时，删除栈顶（队尾）元素（删除前面较小的数字，后面更大的数字顶上来，数字更大）
75. 字符串解密 | 100 | 逻辑分析 |
76. 找等值元素 | 100 | 逻辑分析 |
77. 任务总执行时长 | 100 | 逻辑分析 |
78. 天然蓄水库 | 200 | 双指针 | 接雨水（单调栈
79. 农场施肥 | 100 | 二分查找 | 
80. 组装新的数组 | 200 | 回溯 | 求组合
81. 快速开组建站 | 100 | 拓扑排序/层序遍历 | 
82. 统计友好度最大值 | 100 | 前缀和 | 
83. 荒地建设基站 | 100 | 二维前缀和 |
84. 区块链文件存储系统 | 100 | 滑动窗口 | 最大连续子数组和
85. 新词挖掘 | 100 | 滑动窗口 | 类似 leetcode76
86. 查找充电设备组合 | 100 | DP | 01 背包
87. 上班之路 | 200 | DFS | 
88. 解压缩算法 | 200 | 栈 | 
89. 最优高铁城市修建方案 | 200 | 图-最小生成树 | 1. Kruskal 算法（排序+并查集）：将边从小到大添加到图中，用并查集判断是否有环
90. 垃圾短信识别 | 200 | 逻辑分析 | 
91. 机房布局 | 100 | 模拟 |
92. 静态扫描 | 100 | 贪心 | 
93. 快递投放问题 | 100 | HashMap | 
94. 优秀学员统计 | 100 | HashMap+排序 | 
95. 人数最多的站点 | 200 | 扫描线+优先级队列 | 1. 特殊情况：环线，拆分为两段；<br>
96. 寻找相似单词 | 100 | 模拟+排序 | 
97. 严格递增字符串 | 100 | 动态规划 | 
98. 微服务的集成测试 | 100 | 递归 | 
99. 组合出合法最小数 | 100 | 模拟（排序）|
100. 信号发送与接收 | 200 | 单调栈 | 
101. Linux 发行版数量 | 100  | DFS  |
102. 九宫格 | 200 | 回溯 | 全排列+check |
103. 模拟商场优惠前打折 | 100 | 回溯、模拟 | 
104. 日志限流 | 100 | 二分 | 1. left 为 total/n，right 为 max；
105. 最优芯片资源占用 | 100 | 模拟 | 
106. 工单调度策略| 100 | 扫描线+优先级队列  | 1. 优先级队列按积分从小到大；<br>2. 将修复栈顶积分小的工单的时间，用于修复积分更大的
107. 统一限载最小值  | 100| 二分+回溯 | 1. 是否回溯需要看题意；<br>2. minLimit 为最大的货物量、maxLimit 为所有货物量之和
108. 服务中心选址| 200 | 三分法（三等分/近似三等分） | 1. 距离和是一个凹函数，三分法求极值；
109. 实力差距最小总和 | 200 | 回溯 |
110. 组成直角三角形个数 | 200 | 回溯 |
111. 几何平均值最大子数组 | 100 | 二分+数学 |
112. 构建二叉树 | 200 | 二叉树+层序遍历 |
113. 最长回文子串 | 100 | 排序+模拟 |
114. 大炮攻城 | 200 | 完全背包 |
115. 检测热点字符 | 100 | 排序+模拟 |
116. 数组限制数 | 100 | 二分 | 类似 104
117. 银行插队 | 100 | 优先级队列 | 
118. 称砝码 | 200 | 多重背包 | 不再求最大价值，而是标记dp数组；如果 dp[j - k * weight[i]] = true, 则 dp[j] = true