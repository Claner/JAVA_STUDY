package Design.Command;

/**
 * Created by Clanner on 2017/11/6.
 */
public class RightCommand implements Command{

    private TetrisMachine machine;

    public RightCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toRight();
    }
}
