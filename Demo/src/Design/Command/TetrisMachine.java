package Design.Command;

/**
 * Created by Clanner on 2017/11/6.
 * 俄罗斯方块游戏
 */
public class TetrisMachine {
    public void toLeft(){
        System.out.println("向左");
    }

    public void toRight(){
        System.out.println("向右");
    }

    public void fastDown(){
        System.out.println("快速落下");
    }

    public void transform(){
        System.out.println("改变形状");
    }
}
