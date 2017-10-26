package Algorithm;

import java.util.LinkedList;

/**
 * Created by Clanner on 2017/10/25.
 */
public class TreeNode {
    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
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
