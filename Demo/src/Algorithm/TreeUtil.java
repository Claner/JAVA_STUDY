package Algorithm;

import java.util.LinkedList;

/**
 * Created by Clanner on 2017/10/25.
 * 二叉树工具
 */
public class TreeUtil {

    public static final int DLR = 1;
    public static final int LDR = 2;
    public static final int LRD = 3;
    private StringBuilder builder;

    private TreeUtil() {
        builder = new StringBuilder();
    }

    public static final TreeUtil getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final TreeUtil instance = new TreeUtil();
    }

    /**
     * 层序遍历
     */
    public void printTree(TreeNode head) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        TreeNode last = head;
        TreeNode nlast = last;
        queue.offer(head);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.getVal());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nlast = node.getLeft();
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nlast = node.getRight();
            }
            if (node == last) {
                last = nlast;
                System.out.println();
            }
        }
    }

    /**
     * 前序遍历(根左右)
     */
    public void DLR(TreeNode head) {
        if (head == null) return;
        System.out.print(head.getVal());
        builder.append(head.getVal());
        builder.append("!");
        if (head.getLeft() != null) {
            DLR(head.getLeft());
        } else {
            builder.append("#!");
        }
        if (head.getRight() != null) {
            DLR(head.getRight());
        } else {
            builder.append("#!");
        }
    }

    /**
     * 中序遍历(左根右)
     */
    public void LDR(TreeNode head) {
        if (head == null) return;
        if (head.getLeft() != null) {
            LDR(head.getLeft());
        } else {
            builder.append("#!");
        }
        System.out.print(head.getVal());
        builder.append(head.getVal());
        builder.append("!");
        if (head.getRight() != null) {
            LDR(head.getRight());
        } else {
            builder.append("#!");
        }
    }

    /**
     * 后序遍历(左右根)
     */
    public void LRD(TreeNode head) {
        if (head == null) return;
        if (head.getLeft() != null) {
            LRD(head.getLeft());
        } else {
            builder.append("#!");
        }
        if (head.getRight() != null) {
            LRD(head.getRight());
        } else {
            builder.append("#!");
        }
        System.out.print(head.getVal());
        builder.append(head.getVal());
        builder.append("!");
    }

    /**
     * 判断两个树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.getVal() != q.getVal()) return false;
        return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }

    /**
     * 创建二叉树(反序列化)
     */
    public TreeNode createTreeNode(String str) {
        String[] strings = str.split(":");
        int type;
        if ("type_id".equals(strings[0]) && Util.getInstance().isNumber(strings[1])) {
            type = Integer.parseInt(strings[1]);
        } else {
            type = 0;
        }
        String[] values = strings[2].split("!");
        TreeNode head = new TreeNode(Integer.parseInt(values[0]));
        switch (type) {
            case DLR://前
                break;
            case LDR://中
                break;
            case LRD://后
                break;
            default:
                return null;
        }
        return null;
    }

    /**
     * 序列化
     *
     * @param head 树的根节点
     * @param type 序列化方式
     */
    public String serialize(TreeNode head, int type) {
        builder.append("type_id:");
        builder.append(type);
        builder.append(":");
        switch (type) {
            case DLR:
                DLR(head);
                return builder.toString();
            case LDR:
                LDR(head);
                return builder.toString();
            case LRD:
                LRD(head);
                return builder.toString();
            default:
                return "序列化类型错误";
        }
    }
}
