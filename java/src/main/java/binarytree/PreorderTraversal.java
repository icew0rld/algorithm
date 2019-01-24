package binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal o = new PreorderTraversal();

        TreeNode root = Util.createTree();
        List<TreeNode> l = o.preOrderTraversal(root);
        for (TreeNode node : l) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public List<TreeNode> preOrderTraversal(TreeNode root) {
//        return recurse(root);
        return iterate(root);
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<TreeNode> recurse(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        helper(root.left, res);
        helper(root.right, res);
    }

    /**
     * 迭代写法
     */
    public List<TreeNode> iterate(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }
}
