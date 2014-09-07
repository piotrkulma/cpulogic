package logic.gate;

/**
 * Created by root on 07.09.14.
 */
public class NANDGate extends ANDGate {
    public NANDGate(int a, int b) {
        super(a, b);
    }

    @Override
    public int getOutput() {
        NOTGate not = new NOTGate(super.getOutput());
        return not.getOutput();
    }
}
