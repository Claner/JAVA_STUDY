package javaStudy.design;

/**
 * Created by Clanner on 2018/1/25.
 */
public class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    private static class NullPerson extends Person {
        private NullPerson() {
            super("None", "None");
        }
    }

    public static final Person NULL = new NullPerson();
}
