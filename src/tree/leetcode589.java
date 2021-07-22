package tree;

import java.util.ArrayList;
import java.util.List;

// TODO 589. N 叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
public class leetcode589 {

    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node child: root.children) {
            dfs(child);
        }
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
