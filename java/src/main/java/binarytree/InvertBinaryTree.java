package binarytree;

/**
 * 问题：https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
