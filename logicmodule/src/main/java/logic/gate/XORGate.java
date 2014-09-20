package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public final class XORGate extends LogicGate {
    private ORGate or;
    private NANDGate nand;
    private ANDGate and;

    public XORGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;

        initArchitecture();
        setOutput(this.inA, this.inB);
    }

    @Override
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

    public void initArchitecture() {
        or = new ORGate(this.inA, this.inB);
        nand = new NANDGate(this.inA, this.inB);
        and = new ANDGate(or.getOutput(), nand.getOutput());
    }

    public void setOutput(LogicValue a, LogicValue b) {
        or.setOutput(a, b);
        nand.setOutput(a, b);
        out = and.getOutput();
    }
}
