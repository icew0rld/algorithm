# Permutation

## 排列 permutations

[leetcode #46](https://leetcode.com/problems/permutations/)

backtracking

swap;递归;交换回来就是backtracking

迭代实现？@todo

[Permutations](./java/src/main/java/permutation/Permutations.java)

## 有重复元素的排列 permutations II 

[leetcode #47](https://leetcode.com/problems/permutations-ii/)

backtracking 

在permutations选择交换节点时，用Set去掉重复的

[PermutationsII](./java/src/main/java/permutation/PermutationsII.java) 

## next permutation 

[leetcode #31](https://leetcode.com/problems/next-permutation/)

 swap;reverse 

从右向左找，找到相邻的两个数，他们是升序的；前一个和后面的第一个大于它的数交换；反转第二个以及之后的数。 

[NextPermutation](./java/src/main/java/permutation/NextPermutation.java) 

## permutation sequence 

[leetcode #60](https://leetcode.com/problems/permutation-sequence/)

next permutation k-1次 
第1个位置的值，是数组[1..n]的第k%((n-1)!)个元素，以此类推

[PermutationSequence](./java/src/main/java/permutation/PermutationSequence.java) 

## Generate Parentheses 

[leetcode #22](https://leetcode.com/problems/generate-parentheses/) 

bf; bt; closure number

bt:用递归，结构精巧，不容易理解;closure number:精彩的递归 

## Letter Case Permutation 

[leetcode #784](https://leetcode.com/problems/letter-case-permutation/) 

bt

典型的用递归实现的backtracking

