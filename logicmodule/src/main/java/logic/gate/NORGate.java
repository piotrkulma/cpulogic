package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public final class NORGate extends LogicGate {
    private ORGate or;
    private  NOTGate not;

    public NORGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;
        initArchitecture();
        refresh(this.inA, this.inB);
    }

    public LogicValue getOutput() {
        return not.getOutput();
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;

        or.refresh(inA, inB);
        not.refresh(or.getOutput(), null);
    }

    private void initArchitecture() {
        or = new ORGate(this.inA, this.inB);
        not = new NOTGate(or.getOutput());
    }
}
