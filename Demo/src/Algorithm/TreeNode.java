package Algorithm;

import java.util.LinkedList;

/**
 * Created by Clanner on 2017/10/25.
 * 树
 */
public class TreeNode {
    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 层序构造,构建完全二叉树
     *
     * @param values
     */
    public static TreeNode createTree(int[] values) {
        TreeNode head = new TreeNode(values[0]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        TreeNode last = head;
        TreeNode nlast = last;
        queue.offer(head);

        int i = 1;
        while (i + 1 < values.length) {
            node = queue.poll();
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(values[i++]));
                queue.offer(node.getLeft());
                nlast = node.getLeft();
            }
            if (node.getRight() == null) {
                node.setRight(new TreeNode(values[i++]));
                queue.offer(node.getRight());
                nlast = node.getRight();
            }
            if (node == last) {
                last = nlast;
            }
        }
        return head;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
