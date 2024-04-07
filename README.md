# Leetcode

## 1944 Number of Visible People in a Queue
单调栈，维护一个单调递减的栈，不是的话就弹出计数，注意是否能把栈全部弹空，能弹空的话，弹出的数量就是当前点能看到的人的数量，不是的话还要加一，加上最后一个人，因为最后一个人一定能看到

## 8 String to Integer (atoi)
因为负数比正数大一，判断条件要判断

```java
if (num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && x>Integer.MAX_VALUE%10)) {
    if (sign==1) {
        return Integer.MAX_VALUE;
    }
    else {
        return Integer.MIN_VALUE;
    }
}
```

## 51 N-Queens
Queue位置的比较：列和对角线

对角线的比较：
```java
if (Math.abs(row - row1) == Math.abs(col - col1)) {
    ...
}
```

## 55 Jump Game

Here is Greedy solution.
```java
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;   // Initilize variable reach as 0, to store reach of the highest index.
        for(int i=0;i<nums.length;i++){   // Iterate the nums and check if reach is smaller than i then return false else overwrite reach with max of reach and i+nums[i].
            if(reach<i){
                return false;
            }
            reach = Math.max(reach,i+nums[i]);
        }
        return true;   // return true, beacause we reach the last value of the array nums.
    }
}
```
## 78 Subsets
DFS basic

## 115 Distinct Subsequences
类比于修改多少次可以使两个字符串一样，使用DP的想法
dp[i][j] 含义是在 m[i]下有多少个n[j]的子字符串
dp初始化0行和0列
induction rule :

    如果当前字符和前一个一样，说明可以加或者不加，从dp[i - 1][j - 1]（加），dp[i - 1][j]（不加）
    
    如果不一样，那么就继承前一个
注意dp的String的初始化需要 +1

```java
if (s.charAt(i - 1) == t.charAt(j - 1)) {
    // 当 s[i - 1] == t[j - 1] 时，状态转移方程为 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
} else {
    // 当 s[i - 1] != t[j - 1] 时，状态转移方程为 dp[i][j] = dp[i - 1][j]
    dp[i][j] = dp[i - 1][j];
}
```

## 149 Max Points on a Line
重复的点，水平线，垂直线
用一个第三个点作为媒介，点1和点2之间的斜率如果等于点2和点3之间的斜率，那么我们就找到了一个点3在一条直线上，如果是点1或者点3的话也要将计数加1

```java
for (int i = 0; i < points.length; i++) {
    for (int j = i + 1; j < points.length; j++) {
        max = Math.max(max, find(i, j, points));
    }
}
```

## 198 House Robber
dp easy,初始化条件要记好
```jva
int prev2 = nums[0];
int prev1 = Math.max(nums[0], nums[1]);
```

# Notice
## DP
1. 初始化
2. Induction rule
3. String 类型 offline + 1 ，两个String用二维DP


