# Notice

## DP

1. 初始化
2. Induction rule
3. String 类型 offline + 1 ，两个 String 用二维 DP

<mark>212,399,437,486</mark>

## 311 Sparce matrix multiplication

Method 1: 使用暴力求法

```java
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];

        // 遍历A中的每一个元素
        for(int i=0; i< m; i++){
            for(int j = 0; j< n; j++){
                // 如果不等于0
                if(A[i][j] != 0){
                    // 那么遍历B矩阵在以A矩阵的列为行的所有列
                    // 将结果加到result中
                    for(int k = 0; k<l; k++)
                        C[i][k] += A[i][j]* B[j][k];
                }
            }
        }
        return C;
    }
}
```

Method 2: 使用 HashMap 记录一个矩阵中的元素，遍历另一个矩阵，如果另一个矩阵中的元素不为 0，那么去 map 中查找

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

Queue 位置的比较：列和对角线

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

类比于修改多少次可以使两个字符串一样，使用 DP 的想法
dp[i][j] 含义是在 m[i]下有多少个 n[j]的子字符串
dp 初始化 0 行和 0 列
induction rule :

    如果当前字符和前一个一样，说明可以加或者不加，从dp[i - 1][j - 1]（加），dp[i - 1][j]（不加）

    如果不一样，那么就继承前一个

注意 dp 的 String 的初始化需要 +1

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
用一个第三个点作为媒介，点 1 和点 2 之间的斜率如果等于点 2 和点 3 之间的斜率，那么我们就找到了一个点 3 在一条直线上，如果是点 1 或者点 3 的话也要将计数加 1

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

## 394 Decode String

不断加入 sb 中，直到找到"]",不断向前，将计算好的字符串加入 sb 中

## 475 Heaters

对 house 和 heater 都 sort，然后用 binary search，让 left = 0； right = house 和 heater 中最大的，mid 为能加热的距离

## 695 Max Area of Island

## 721 Accounts Merge
类似于找island 的思想，用boolean array记录是否找到过，记住用set记录内容的时候，不是空才能加入。

## 743 Network Delay Time
use a minHeap, Dijkstra's Algorithm

## 785 Is bipartite？
看注释
```java
for (int i = 0; i < graph.length; i++) {
    // 如果map中不存在说明是新点，随便给他一个flag
    if (map.containsKey(i)) {
            continue;
    // 如果map中存在，说明一定可以成功，跳过
    } else {
        map.put(i, 0);
        q.offer(new int[] {i, 0});
    }

    // 遍历所有neibours，记住只有新点可以加入queue，旧点只需要比较
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int id = cur[0];
        int flag = cur[1];
        int neiFlag = (flag == 0 ? 1 : 0);

        for (int j = 0; j < graph[id].length; j++) {
            if (!map.containsKey(graph[id][j])) {
                map.put(graph[id][j], neiFlag);
                q.offer(new int[] {graph[id][j], neiFlag});
            } else if (map.get(graph[id][j]) != neiFlag) {
                return false;
            }
        }
    }
}
```

## 112 Path Sum （root to leaf）
1. 一定要在leaf节点判断（left == null && right == null）
2. 有左和有右的时候才能往下走，不然会在当前node判断

## 137 Single Number II
可以用两个set，也可以用一个map和位运算^

## 209 Minimum Size Subarray Sum
Use two pointers, matain a sum

```java
while (right < nums.length) {
    sum += nums[right];
    while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left++];
    }
    right++;
}
```

## # Notice

## DP

1. 初始化
2. Induction rule
3. String 类型 offline + 1 ，两个 String 用二维 DP

<mark>212,399,437,486</mark>
## 311 Sparce matrix multiplication

Method 1: 使用暴力求法

```java
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];

        // 遍历A中的每一个元素
        for(int i=0; i< m; i++){
            for(int j = 0; j< n; j++){
                // 如果不等于0
                if(A[i][j] != 0){
                    // 那么遍历B矩阵在以A矩阵的列为行的所有列
                    // 将结果加到result中
                    for(int k = 0; k<l; k++)
                        C[i][k] += A[i][j]* B[j][k];
                }
            }
        }
        return C;
    }
}
```

Method 2: 使用 HashMap 记录一个矩阵中的元素，遍历另一个矩阵，如果另一个矩阵中的元素不为 0，那么去 map 中查找

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

Queue 位置的比较：列和对角线

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

类比于修改多少次可以使两个字符串一样，使用 DP 的想法
dp[i][j] 含义是在 m[i]下有多少个 n[j]的子字符串
dp 初始化 0 行和 0 列
induction rule :

    如果当前字符和前一个一样，说明可以加或者不加，从dp[i - 1][j - 1]（加），dp[i - 1][j]（不加）

    如果不一样，那么就继承前一个

注意 dp 的 String 的初始化需要 +1

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
用一个第三个点作为媒介，点 1 和点 2 之间的斜率如果等于点 2 和点 3 之间的斜率，那么我们就找到了一个点 3 在一条直线上，如果是点 1 或者点 3 的话也要将计数加 1

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

## 394 Decode String

不断加入 sb 中，直到找到"]",不断向前，将计算好的字符串加入 sb 中

## 475 Heaters

对 house 和 heater 都 sort，然后用 binary search，让 left = 0； right = house 和 heater 中最大的，mid 为能加热的距离

## 695 Max Area of Island

## 721 Accounts Merge
类似于找island 的思想，用boolean array记录是否找到过，记住用set记录内容的时候，不是空才能加入。

## 743 Network Delay Time
use a minHeap, Dijkstra's Algorithm

## 785 Is bipartite？
看注释
```java
for (int i = 0; i < graph.length; i++) {
    // 如果map中不存在说明是新点，随便给他一个flag
    if (map.containsKey(i)) {
            continue;
    // 如果map中存在，说明一定可以成功，跳过
    } else {
        map.put(i, 0);
        q.offer(new int[] {i, 0});
    }

    // 遍历所有neibours，记住只有新点可以加入queue，旧点只需要比较
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int id = cur[0];
        int flag = cur[1];
        int neiFlag = (flag == 0 ? 1 : 0);

        for (int j = 0; j < graph[id].length; j++) {
            if (!map.containsKey(graph[id][j])) {
                map.put(graph[id][j], neiFlag);
                q.offer(new int[] {graph[id][j], neiFlag});
            } else if (map.get(graph[id][j]) != neiFlag) {
                return false;
            }
        }
    }
}
```

## 112 Path Sum （root to leaf）
1. 一定要在leaf节点判断（left == null && right == null）
2. 有左和有右的时候才能往下走，不然会在当前node判断

## 137 Single Number II
可以用两个set，也可以用一个map和位运算^

## 209 Minimum Size Subarray Sum
Use two pointers, matain a sum

```java
while (right < nums.length) {
    sum += nums[right];
    while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left++];
    }
    right++;
}
```
# Notice

## DP

1. 初始化
2. Induction rule
3. String 类型 offline + 1 ，两个 String 用二维 DP

<mark>212,399,437,486</mark>
## 311 Sparce matrix multiplication

Method 1: 使用暴力求法

```java
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];

        // 遍历A中的每一个元素
        for(int i=0; i< m; i++){
            for(int j = 0; j< n; j++){
                // 如果不等于0
                if(A[i][j] != 0){
                    // 那么遍历B矩阵在以A矩阵的列为行的所有列
                    // 将结果加到result中
                    for(int k = 0; k<l; k++)
                        C[i][k] += A[i][j]* B[j][k];
                }
            }
        }
        return C;
    }
}
```

Method 2: 使用 HashMap 记录一个矩阵中的元素，遍历另一个矩阵，如果另一个矩阵中的元素不为 0，那么去 map 中查找

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

Queue 位置的比较：列和对角线

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

类比于修改多少次可以使两个字符串一样，使用 DP 的想法
dp[i][j] 含义是在 m[i]下有多少个 n[j]的子字符串
dp 初始化 0 行和 0 列
induction rule :

    如果当前字符和前一个一样，说明可以加或者不加，从dp[i - 1][j - 1]（加），dp[i - 1][j]（不加）

    如果不一样，那么就继承前一个

注意 dp 的 String 的初始化需要 +1

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
用一个第三个点作为媒介，点 1 和点 2 之间的斜率如果等于点 2 和点 3 之间的斜率，那么我们就找到了一个点 3 在一条直线上，如果是点 1 或者点 3 的话也要将计数加 1

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

## 394 Decode String

不断加入 sb 中，直到找到"]",不断向前，将计算好的字符串加入 sb 中

## 475 Heaters

对 house 和 heater 都 sort，然后用 binary search，让 left = 0； right = house 和 heater 中最大的，mid 为能加热的距离

## 695 Max Area of Island

## 721 Accounts Merge
类似于找island 的思想，用boolean array记录是否找到过，记住用set记录内容的时候，不是空才能加入。

## 743 Network Delay Time
use a minHeap, Dijkstra's Algorithm

## 785 Is bipartite？
看注释
```java
for (int i = 0; i < graph.length; i++) {
    // 如果map中不存在说明是新点，随便给他一个flag
    if (map.containsKey(i)) {
            continue;
    // 如果map中存在，说明一定可以成功，跳过
    } else {
        map.put(i, 0);
        q.offer(new int[] {i, 0});
    }

    // 遍历所有neibours，记住只有新点可以加入queue，旧点只需要比较
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int id = cur[0];
        int flag = cur[1];
        int neiFlag = (flag == 0 ? 1 : 0);

        for (int j = 0; j < graph[id].length; j++) {
            if (!map.containsKey(graph[id][j])) {
                map.put(graph[id][j], neiFlag);
                q.offer(new int[] {graph[id][j], neiFlag});
            } else if (map.get(graph[id][j]) != neiFlag) {
                return false;
            }
        }
    }
}
```

## 112 Path Sum （root to leaf）
1. 一定要在leaf节点判断（left == null && right == null）
2. 有左和有右的时候才能往下走，不然会在当前node判断

## 137 Single Number II
可以用两个set，也可以用一个map和位运算^

## 209 Minimum Size Subarray Sum
Use two pointers, matain a sum

```java
while (right < nums.length) {
    sum += nums[right];
    while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left++];
    }
    right++;
}
```

## 486 Predict the Winner
Use a helper function to record what is the score difference from now, nums[left] - helper(left+1, right)表示user在选left的时候比分差距是多少