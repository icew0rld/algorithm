# Tree

## 遍历

### dfs二叉树先序遍历

递归；迭代；Morris遍历

迭代用栈，简单

[PreorderTraversal](./java/src/main/java/binarytree/PreorderTraversal.java)

### dfs二叉树中序遍历

递归；迭代；Morris遍历

迭代用栈，较复杂，需要用一个指针一直走到左树的尽头，并从右子树再开始

[InorderTraversal](./java/src/main/java/binarytree/InorderTraversal.java)

### dfs二叉树后序遍历

递归；迭代；Morris遍历

迭代用栈，较复杂，需要看一下stack中的第一个节点，并且要一个指针记录上一个出栈的节点

[PostorderTraversal](./java/src/main/java/binarytree/PostorderTraversal.java)



注：dfs三种顺序遍历的的迭代写法，有一种统一的结构的优美解法：[link](https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization)

### bfs二叉树层序遍历

迭代

迭代用队列

## 路径

| 问题域                                   | 解域           | 要点 | Java实现 |
| ---------------------------------------- | -------------- | ---- | -------- |
| 求二叉树中和为某一值的路径 剑指offer #25 | 先序遍历+stack |      |          |

## 二叉树 vs 数组

| 问题域                                                   | 解域 | 要点                                                       | Java实现 |
| -------------------------------------------------------- | ---- | ---------------------------------------------------------- | -------- |
| 根据前序遍历和中序遍历结果重建二叉树 剑指offer #6        | 递归 | 根节点位于前序遍历结果的第一个，同时位于中序遍历结果的中间 |          |
| 判断一个序列是否是二叉搜索树的后序遍历序列 剑指offer #24 | -    | 序列的最后一个元素是根节点                                 |          |

## 节点

公共祖先

| 问题域                                                       | 解域       | 要点 | Java实现                                                     |
| ------------------------------------------------------------ | ---------- | ---- | ------------------------------------------------------------ |
| 反转二叉树 [leetcode #226](https://leetcode.com/problems/invert-binary-tree/) | 递归；迭代 |      | [InvertBinaryTree](./java/src/main/java/binarytree/InvertBinaryTree.java) |
| 树中两个节点的最低公共祖先 剑指offer #50                     |            |      |                                                              |
| 合并二叉树                                                   |            |      |                                                              |
| Convert BST to Greater Tree [leetcode #538](https://leetcode.com/problems/convert-bst-to-greater-tree/) | 中序遍历   | -    | [GreaterTree](./java/src/main/java/binarytree/GreaterTree.java) |
| 求二叉树的直径                                               |            |      |                                                              |
| 从数组构造最大二叉树                                         | 递归       |      |                                                              |



## 求树的属性

| 问题域                 | 解域     | 要点                                           | Java实现 |
| ---------------------- | -------- | ---------------------------------------------- | -------- |
| 求二叉树的最大深度     | dfs;bfs  | dfs：递归写法;dfs：迭代写法;bfs：迭代写法      |          |
| 判断二叉树是否是平衡树 | 后序遍历 | 后序是先遍历子树，所以子树深度可得，只遍历一次 |          |

## BST

| 问题域                     | 解域     | 要点 | Java实现 |
| -------------------------- | -------- | ---- | -------- |
| 将二叉搜索树转化为双向链表 | 中序遍历 |      |          |



## 结构

### 翻转等价判断

```
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 == null || root2 == null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
    }
}
```

### 判断一棵二叉树是不是另一棵二叉树的子结构 

剑指offer #18 

递归

### 求二叉树的镜像 

剑指offer #19

递归 