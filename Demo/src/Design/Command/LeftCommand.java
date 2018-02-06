package Design.Command;

/**
 * Created by Clanner on 2017/11/6.
 */
public class LeftCommand implements Command{

    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toLeft();
    }
}
