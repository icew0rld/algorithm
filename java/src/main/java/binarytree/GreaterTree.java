package binarytree;

/**
 * 问题：https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class GreaterTree {
    public TreeNode convertBST(TreeNode root) {
        converHelper(root, 0);
        return root;
    }

    private int converHelper(TreeNode root, int val) {
        if (root == null) {
            return val;
        }

        root.val += converHelper(root.right, val);
        return converHelper(root.left, root.val);
    }


    private int sum = 0;

    /**
     * 递归函数少了一个参数，更易读
     * @param root
     * @return
     */
    public TreeNode convertBSTOptimal(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
