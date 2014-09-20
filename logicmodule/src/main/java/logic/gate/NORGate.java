package logic.gate;

import logic.LogicValue;

/**
 * Created by root on 07.09.14.
 */
public final class NORGate extends LogicGate {
    private ORGate or;
    private  NOTGate not;

    public NORGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;
        initArchitecture();
        setOutput(this.inA, this.inB);
    }

    public LogicValue getOutput() {
        setOutput(this.inA, this.inB);

        return out;
    }

    public LogicValue getInputA() {
        return inA;
    }

    public void setInputA(LogicValue inA) {
        this.inA = inA;
        setOutput(this.inA, this.inB);
    }

    public LogicValue getInputB() {
        return inB;
    }

    public void setInputB(LogicValue inB) {
        this.inB = inB;
        setOutput(this.inA, this.inB);
    }

    public void setOutput(LogicValue a, LogicValue b) {
        or.setOutput(a, b);
        out = not.getOutput();
    }

    private void initArchitecture() {
        or = new ORGate(this.inA, this.inB);
        not = new NOTGate(or.getOutput());
    }
}
