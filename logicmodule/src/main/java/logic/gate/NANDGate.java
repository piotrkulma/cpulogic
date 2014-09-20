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
        setOutput(this.inA, this.inB);
    }

    public LogicValue getOutput() {
        setOutput(this.inA, this.inB);
        return out;
    }

    public void setInputA(LogicValue inA) {
        this.inA = inA;
        setOutput(this.inA, this.inB);
    }

    public void setInputB(LogicValue inB) {
        this.inB = inB;
        setOutput(this.inA, this.inB);
    }

    private void initArchitecture() {
        and = new ANDGate(this.inA, this.inB);
        not = new NOTGate(and.getOutput());
    }

    public void setOutput(LogicValue a, LogicValue b) {
        and.setOutput(a, b);
        out = not.getOutput();
    }
}
