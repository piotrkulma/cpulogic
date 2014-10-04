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

    public void setInputA(LogicValue inA) {
        this.inA = inA;
    }

    public void setInputB(LogicValue inB) {
        this.inB = inB;
    }

    private void initArchitecture() {
        and = new ANDGate(this.inA, this.inB);
        not = new NOTGate(and.getOutput());
    }

    public void refresh(LogicValue a, LogicValue b) {
        and.refresh(a, b);
        not.refresh(and.getOutput(), null);
    }
}
