package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题：中序遍历 https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 难度：medium
 */
public class InorderTraversal {
    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> recurse(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        helper(root, l);
        return l;
    }

    private void helper(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        helper(root.left, l);
        l.add(root.val);
        helper(root.right, l);
    }

    /**
     * 迭代写法
     */
    public List<Integer> iterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Morris Traversal (非递归，不用栈)
     */
    public List<Integer> morris(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}
