package javaStudy.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Clanner on 2018/2/9.
 * 原子更新数组
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
