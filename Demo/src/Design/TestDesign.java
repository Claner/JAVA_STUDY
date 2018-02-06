package Design;

import Design.Command.*;
import Design.Duty.Boss;
import Design.Duty.Director;
import Design.Duty.GroupLeader;
import Design.Duty.Manager;

/**
 * Created by Clanner on 2017/11/6.
 * 测试类
 */
public class TestDesign {
    public static void main(String[] args) {
        //责任链模式
        Boss boss = new Boss();
        Manager manager = new Manager(boss);
        Director director = new Director(manager);
        GroupLeader groupLeader = new GroupLeader(director);
        groupLeader.handleRequest(15000);

        //命令模式
        TetrisMachine machine = new TetrisMachine();

        LeftCommand leftCommand = new LeftCommand(machine);
        RightCommand rightCommand = new RightCommand(machine);
        FallCommand fallCommand = new FallCommand(machine);
        TransformCommand transformCommand = new TransformCommand(machine);

        Button button = new Button();
        button.setLeftCommand(leftCommand);
        button.setRightCommand(rightCommand);
        button.setFallCommand(fallCommand);
        button.setTransformCommand(transformCommand);

        button.toLeft();
        button.toRight();
        button.fall();
        button.transform();
    }
}
