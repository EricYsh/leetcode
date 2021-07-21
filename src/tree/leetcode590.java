package tree;

import java.util.ArrayList;
import java.util.List;

// TODO 590. N 叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
public class leetcode590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root != null) {
            for (Node cur : root.children) {
                if (cur != null)
                    postOrder(cur, res);
            }
            res.add(root.val);
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
