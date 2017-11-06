import Algorithm.Good;
import Algorithm.TreeNode;
import Algorithm.TreeUtil;
import Algorithm.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Clanner on 2017/4/28.
 * 0，1背包问题
 */
public class Test {
    private static Good[] goods = {new Good(50, 101), new Good(20, 100), new Good(30, 120)};
    private static final String MESSAGE = "taobao";

    static String str0 = "0123456789";
    static String str1 = "0123456789";
    String str2 = str0.substring(5);
    String str3 = new String(str2);
    String str4 = new String(str3.toCharArray());

    public static void main(String[] args) throws InterruptedException {
//        str0 = null;
//        System.out.println(str0);
//        System.out.println(str1);
//        System.gc();
//        System.out.println(str0);
//        System.out.println(str1);
//        String str = "if (r >= num.text()){ C = 2.0*=pi*r;}";
//        Util.getInstance().lexicalAnalysis(str);

//        try {
//            InputStream is = new FileInputStream("d:\\TestClass.class");
//            byte[] b  = new byte[is.available()];
//            is.read(b);
//            is.close();
//
//            System.out.println(JavaClassExecuter.execute(b));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Window window1 = new Window();
//        Window2 window2 = new Window2();
//        window1.start();
//        window2.start();

//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6=b4+b5;
//        b3= (byte) (b1+b2);
//        System.out.println(b3+b6);

//        Thread t = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.print("2");
//            }
//        });
//        t.start();
//
//        t.join();
//        System.out.print(Math.floor(-8.5));

//        String a ="tao"+"bao";
//        String b="tao";
//        String c="bao";
//        System.out.println(a==MESSAGE);
//        System.out.println((b+c)==MESSAGE);

//        Util.getInstance().calStr("wwwwssffiuuuuusssssooooolllsssssshhhhcccchhhhhllo");
//        ((Util)null).calStr("wwwwssffiuuuuusssssooooolllsssssshhhhcccchhhhhllo");
//        int[] values = {20, 13, 24, 32, 42, 5, 8, 1, 2, 3, 5, 2, 1, 3};
//        SortUtil.getInstance().countingSort(values);
//        for (int i : values) System.out.print(i + ",");

//        int[] a = {3, 1, 8, 4, 5, 7, 6, 2};
//        TreeNode head = TreeNode.createTree(a);
//        TreeUtil.getInstance().printTree(head);

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(new TreeNode(4));
        left.setRight(null);
        TreeNode left2 = new TreeNode(5);
        right.setLeft(left2);
        right.setRight(new TreeNode(6));
        left2.setLeft(new TreeNode(7));
        left2.setRight(new TreeNode(8));
        TreeUtil.getInstance().printTree(root);
        String s = TreeUtil.getInstance().serialize(root, TreeUtil.DLR);
//        System.out.println(s);
//        TreeNode node = TreeUtil.getInstance().createTreeNode(s);
//        TreeUtil.getInstance().printTree(node);
//        s = TreeUtil.getInstance().serialize(root, TreeUtil.LDR);
//        System.out.println(s);
        s = TreeUtil.getInstance().serialize(root, TreeUtil.LRD);
        System.out.println(s);
//        s = TreeUtil.getInstance().serialize(root, TreeUtil.LEVEL);
//        System.out.println(s);

//        TreeNode node = TreeUtil.getInstance().createTreeNode(s);
//        TreeUtil.getInstance().printTree(node);
//        System.out.println(Util.getInstance().rotationPosition("ABCDE",2));

//        int[] a = {1,2,3,4,5,6,7};
//        TreeNode node = TreeUtil.getInstance().createTree(a);
//        TreeUtil.getInstance().lrd_by_stack(node);
//        TreeUtil.getInstance().LRD(node);

//        Good[] goods = {new Good(1, 1), new Good(2, 2), new Good(3, 3)};
//        System.out.println("最大价值为：" + Util.getInstance().getBagMaxValue(goods, 6));
    }
}
