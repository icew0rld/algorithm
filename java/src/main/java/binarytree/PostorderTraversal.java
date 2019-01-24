package binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal o = new PostorderTraversal();

        TreeNode root = Util.createTree();
        List<TreeNode> l = o.postorderTraversal(root);
        for (TreeNode node : l) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public List<TreeNode> postorderTraversal(TreeNode root) {
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
        helper(root.left, res);
        helper(root.right, res);
        res.add(root);
    }

    /**
     * 迭代写法
     * @param root
     * @return
     */
    public List<TreeNode> iterate(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode look = null;
            TreeNode pre = root;
            while (!stack.isEmpty()) {
                look = stack.peek();
                if (look.left != null && look.left != pre && look.right != pre) {
                    stack.push(look.left);
                } else if (look.right != null && look.right != pre) {
                    stack.push(look.right);
                } else {
                    res.add(stack.pop());
                    pre = look;
                }
            }
        }
        return res;
    }
}
