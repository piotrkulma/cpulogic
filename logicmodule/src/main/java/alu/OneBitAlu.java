package alu;

import alu.adder.FullAdder;
import alu.subtractor.FullSubtractor;
import logic.LogicValue;
import logic.gate.ANDGate;
import logic.gate.NOTGate;
import logic.gate.ORGate;
import logic.gate.XORGate;

/**
 * Created by Piotr Kulma on 20.09.14.
 *
 * Jednobitowe ALU, implementacja umozliwiająca wykonywanie
 * poniższych operacji:
 *
 * S2   S1  S0  OPERACJA
 * 0    0   0   A AND B
 * 0    0   1   A OR B
 * 0    1   0   NOT A
 * 0    1   1   A XOR B
 * 1    0   0   B + A
 * 1    0   1   B - A
 * 1    1   0   wolne
 * 1    1   1   wolne
 *
 * Wejścia: A, B, Kod operacji
 * Wyjścia: Wynik operacji, carry output
 */

public class OneBitAlu {
    private LogicValue operationCode[];
    private LogicValue inputA;
    private LogicValue inputB;
    private LogicValue carryInput;

    private LogicValue operationResult;
    private LogicValue carryOutput;

    private ANDGate and;
    private ORGate or;
    private NOTGate not;
    private XORGate xor;
    private FullAdder fullAdder;
    private FullSubtractor fullSubtractor;

    private TwoToOneMultiplexer s0_0;
    private TwoToOneMultiplexer s0_1;
    private TwoToOneMultiplexer s0_2;
    private TwoToOneMultiplexer s0_3;

    private TwoToOneMultiplexer s1_0;
    private TwoToOneMultiplexer s1_1;

    private TwoToOneMultiplexer s2_0;

    public OneBitAlu(LogicValue operationCode[], LogicValue carryInput, LogicValue inputA, LogicValue inputB) {
        this.operationCode = operationCode;
        this.carryInput = carryInput;
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitectureElements();
    }

    public void setOperationCode(LogicValue[] operationCode) {
        this.operationCode = operationCode;
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
    }

    public void setCarryInput(LogicValue carryInput) {
        this.carryInput = carryInput;
    }

    public LogicValue getOperationResult() {
        return operationResult;
    }

    public LogicValue getCarryOutput() {
        return carryOutput;
    }

    private void initArchitectureElements() {
        and = new ANDGate(inputA, inputB);
        or = new ORGate(inputA, inputB);
        not = new NOTGate(inputA);
        xor = new XORGate(inputA, inputB);
        fullAdder = new FullAdder(carryInput, inputA, inputB);
        fullSubtractor = new FullSubtractor(carryInput, inputA, inputB);

        s0_0 = new TwoToOneMultiplexer(operationCode[0], and.getOutput(), or.getOutput());
        s0_1 = new TwoToOneMultiplexer(operationCode[0], not.getOutput(), xor.getOutput());
        s0_2 = new TwoToOneMultiplexer(operationCode[0], fullAdder.getOutput(), null);
        s0_3 = new TwoToOneMultiplexer(operationCode[0], null, null);

        s1_0 = new TwoToOneMultiplexer(operationCode[1], s0_1.getOutput(), s0_0.getOutput());
        s1_1 = new TwoToOneMultiplexer(operationCode[2], s0_3.getOutput(), s0_2.getOutput());

        s2_0 = new TwoToOneMultiplexer(operationCode[2], s1_1.getOutput(), s1_0.getOutput());
    }
}
