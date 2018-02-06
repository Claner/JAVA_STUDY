package Design.Command;

/**
 * Created by Clanner on 2017/11/6.
 */
public class FallCommand implements Command{

    private TetrisMachine machine;

    public FallCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.fastDown();
    }
}
