# Array

## move zeros

 [leetcode #283](https://leetcode.com/problems/move-zeroes/)

two pointers

slow pointer前是non-zeroes, slow pointer和cur pointer之是zeroes

[MoveZeroes](./java/src/main/java/array/MoveZeroes.java)

## Find All Numbers Disappeared in an Array

 [leetcode #448](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

swap; mark

mark: 出现过的位置+=n 或 变为负数

[FindDisappeared](./java/src/main/java/array/FindDisappeared.java)

## Majority Element

bf;hashtable;sort;dc;Boyer-Moore Voting

bf,hashtable,sort显而易见；Boyer-Moore Voting:相同+1不同-1； dc: 左右如果不同，扫描一遍

[MajorityElement](./java/src/main/java/array/MajorityElement.java)

## 调整数组顺序使奇数位于偶数前

剑指offer #14

two pointers

题目本身不难，但注意高阶函数的应用

[OddBeforeEven](./java/src/main/java/array/OddBeforeEven.java)

## 连续子数组的最大和 

剑指offer #31

bf;直观累加;dp 

直观累加和dp结果相同，掌握dp即可 

## 第一个只出现一次的字符 

剑指offer #35

bf; hashtable 

如果不用实现hashtable，则很简单 



## 数组中的逆序对 

剑指offer #36

bf; dc 

 dc:在归并排序的过程中统计逆序对 

## 旋转数组

 [leetcode #189](https://leetcode.com/problems/rotate-array/) 

bf;额外数组;原地替换;反转 

原地替换比较难理解;反转写法最好 

## Top K Frequent Elements

 [leetcode #347](https://leetcode.com/problems/top-k-frequent-elements/) 

hashtable + heap

 思路清楚，注意heap在java中是被PriorityQueue类实现 