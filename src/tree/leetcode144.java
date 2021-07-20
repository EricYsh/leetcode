package tree;

import java.util.ArrayList;
import java.util.List;

//TODO 144. 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class leetcode144 {
    // TODO 为什么树的面试题大多都是递归？取决于树的结构。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
