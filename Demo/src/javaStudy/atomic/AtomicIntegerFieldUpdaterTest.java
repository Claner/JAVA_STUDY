package javaStudy.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by Clanner on 2018/2/9.
 */
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args) {
        User user = new User("Clanner",22);
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));
        System.out.println(atomicIntegerFieldUpdater.get(user));
    }

    static class User {
        private String name;
        public volatile int age;

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
