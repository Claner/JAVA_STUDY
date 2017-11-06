package Algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Clanner on 2017/10/25.
 * 二叉树工具
 */
public class TreeUtil {

    public static final int DLR = 1;
    public static final int LDR = 2;
    public static final int LRD = 3;
    public static final int LEVEL = 4;
    private int index = -1;

    private TreeUtil() {
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
     * 前序序列化
     */
    private void serialize_dlr(TreeNode head, StringBuilder builder) {
        if (head != null) {
            builder.append(head.getVal());
            builder.append("!");
        } else {
            builder.append("#!");
            return;
        }
        serialize_dlr(head.getLeft(), builder);
        serialize_dlr(head.getRight(), builder);
    }

    /**
     * 前序反序列化
     */
    private TreeNode deserialize_dlr(String[] strings) {
        index++;
        if (!strings[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.setVal(Integer.parseInt(strings[index]));
            root.setLeft(deserialize_dlr(strings));
            root.setRight(deserialize_dlr(strings));
            return root;
        } else {
            return null;
        }
    }

    /**
     * 中序序列化
     */
    private void serialize_ldr(TreeNode head, StringBuilder builder) {
        if (head.getLeft() != null) {
            serialize_ldr(head.getLeft(), builder);
        } else {
            builder.append("#!");
        }
        builder.append(head.getVal());
        builder.append("!");
        if (head.getRight() != null) {
            serialize_ldr(head.getRight(), builder);
        } else {
            builder.append("#!");
        }
    }

    /**
     * 后序序列化
     */
    private void serialize_lrd(TreeNode head, StringBuilder builder) {
        if (head.getLeft() != null) {
            serialize_lrd(head.getLeft(), builder);
        } else {
            builder.append("#!");
        }
        if (head.getRight() != null) {
            serialize_lrd(head.getRight(), builder);
        } else {
            builder.append("#!");
        }
        builder.append(head.getVal());
        builder.append("!");
    }

    /**
     * 层序序列化
     */
    public void serialize_level(TreeNode head, StringBuilder builder) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        TreeNode last = head;
        TreeNode nlast = last;
        queue.offer(head);

        while (!queue.isEmpty()) {
            node = queue.poll();
            builder.append(node.getVal());
            builder.append("!");
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nlast = node.getLeft();
            } else {
                builder.append("#!");
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nlast = node.getRight();
            } else {
                builder.append("#!");
            }
            if (node == last) {
                last = nlast;
            }
        }
    }

    private void deserialize_level(){

    }

    /**
     * 前序遍历(根左右)
     */
    public void DLR(TreeNode head) {
        if (head == null) return;
        System.out.print(head.getVal());
        if (head.getLeft() != null) DLR(head.getLeft());
        if (head.getRight() != null) DLR(head.getRight());
    }

    /**
     * 前序遍历（非递归）
     */
    public void dlr_by_stack(TreeNode head) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getVal());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
     * 中序遍历(左根右)
     */
    public void LDR(TreeNode head) {
        if (head == null) return;
        if (head.getLeft() != null) LDR(head.getLeft());
        System.out.print(head.getVal());
        if (head.getRight() != null) LDR(head.getRight());
    }

    /**
     * 中序遍历(非递归)
     */
    public void ldr_by_stack(TreeNode head) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);//左孩子依次入栈
                cur = cur.getLeft();
            } else {//左孩子为空时，打印节点值
                cur = stack.pop();
                System.out.print(cur.getVal());
                cur = cur.getRight();
            }
        }
    }


    /**
     * 后序遍历(左右根)
     */
    public void LRD(TreeNode head) {
        if (head == null) return;
        if (head.getLeft() != null) LRD(head.getLeft());
        if (head.getRight() != null) LRD(head.getRight());
        System.out.print(head.getVal());
    }

    /**
     * 后序遍历(非递归)
     */
    public void lrd_by_stack(TreeNode head) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.getLeft() != null) s1.push(node.getLeft());
            if (node.getRight() != null) s1.push(node.getRight());
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().getVal());
        }
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

        switch (type) {
            case DLR://前
                return deserialize_dlr(values);
            case LDR://中
                //中序无法单独序列化，因为无法确定根节点
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
        StringBuilder builder = new StringBuilder();
        builder.append("type_id:");
        builder.append(type);
        builder.append(":");
        switch (type) {
            case DLR:
                serialize_dlr(head, builder);
                return builder.toString();
            case LDR:
                serialize_ldr(head, builder);
                return builder.toString();
            case LRD:
                serialize_lrd(head, builder);
                return builder.toString();
            case LEVEL:
                serialize_level(head, builder);
                return builder.toString();
            default:
                return "序列化类型错误";
        }
    }

    /**
     * 层序构造,构建完全二叉树
     *
     * @param values
     */
    public TreeNode createTree(int[] values) {
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
}
