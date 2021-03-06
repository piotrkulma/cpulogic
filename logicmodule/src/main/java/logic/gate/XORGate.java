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
    }

    @Override
    public LogicValue getOutput() {
        return and.getOutput();
    }

    public void initArchitecture() {
        or = new ORGate(this.inA, this.inB);
        nand = new NANDGate(this.inA, this.inB);
        and = new ANDGate(or.getOutput(), nand.getOutput());
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;

        or.refresh(inA, inB);
        nand.refresh(inA, inB);
        and.refresh(or.getOutput(), nand.getOutput());
    }
}
