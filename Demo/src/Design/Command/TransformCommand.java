package Design.Command;

/**
 * Created by Clanner on 2017/11/6.
 */
public class TransformCommand implements Command{

    private TetrisMachine machine;

    public TransformCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.transform();
    }
}
