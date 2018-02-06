package javaStudy.C;

/**
 * Created by Clanner on 2018/1/23.
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString() ;
}
