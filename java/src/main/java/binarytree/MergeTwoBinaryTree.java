package binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题：https://leetcode.com/problems/merge-two-binary-trees/
 * 难度：easy、medium
 * 思路：1.递归（easy） 2.迭代（medium）
 */
public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // return recurse(t1, t2);
        return iterate(t1, t2);
    }

    public TreeNode recurse(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    public TreeNode iterate(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Deque<TreeNode[]> s = new LinkedList<>();
        s.push(new TreeNode[]{t1, t2});
        while (!s.isEmpty()) {
            TreeNode[] t = s.pop();

            if (t[1] == null) {
                continue;
            }

            t[0].val += t[1].val;
            if (t[0].left == null){
                t[0].left = t[1].left;
            } else {
                s.push(new TreeNode[]{t[0].left, t[1].left});
            }

            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                s.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Util {
    public static TreeNode createTree() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        return t1;
    }
}

