package FarExecuter;

/**
 * Created by Clanner on 2017/10/16.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("Dao.UserDao");
        } catch (ClassNotFoundException e) {
            System.out.println("类不存在");
        }
    }
}
