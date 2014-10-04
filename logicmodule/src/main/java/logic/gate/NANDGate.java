package logic.gate;


import logic.LogicValue;

/**
 * Created by root on 07.09.14.
 */
public final class NANDGate extends LogicGate {
    private ANDGate and;
    private NOTGate not;

    public NANDGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;
        initArchitecture();
    }

    public LogicValue getOutput() {
        return not.getOutput();
    }

    private void initArchitecture() {
        and = new ANDGate(this.inA, this.inB);
        not = new NOTGate(and.getOutput());
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;

        and.refresh(inA, inB);
        not.refresh(and.getOutput(), null);
    }
}
