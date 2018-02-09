package javaStudy.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Clanner on 2018/2/9.
 * 原子更新引用类型
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("Clanner", 22);
        atomicReference.set(user);
        User updateUser = new User("Cafe", 18);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());
    }

    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
