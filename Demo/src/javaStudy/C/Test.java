package javaStudy.C;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Clanner on 2018/1/23.
 */
public class Test {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}
