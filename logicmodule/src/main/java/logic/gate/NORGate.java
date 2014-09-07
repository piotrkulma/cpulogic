package logic.gate;

/**
 * Created by root on 07.09.14.
 */
public class NORGate extends ORGate {
    public NORGate(int a, int b) {
        super(a, b);
    }

    @Override
    public int getOutput() {
        NOTGate not = new NOTGate(super.getOutput());
        return not.getOutput();
    }
}
