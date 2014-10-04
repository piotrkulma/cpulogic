package cpu.alu;

import cpu.alu.adder.FullAdder;
import cpu.alu.subtractor.FullSubtractor;
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

    private ANDGate and;
    private ORGate or;
    private NOTGate not;
    private XORGate xor;

    private FullAdder fullAdder;
    private FullSubtractor fullSubtractor;
    private TwoToOneMultiplexer carryOutMultiplexer;


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

        initArchitecture();
    }

    public LogicValue getOperationOutput() {
        return s2_0.getOutput();
    }

    public LogicValue getCarryOutput() {
        return carryOutMultiplexer.getOutput();
    }

    private void initArchitecture() {
        and = new ANDGate(inputA, inputB);
        or = new ORGate(inputA, inputB);
        not = new NOTGate(inputA);
        xor = new XORGate(inputA, inputB);

        fullAdder = new FullAdder(carryInput, inputA, inputB);
        fullSubtractor = new FullSubtractor(carryInput, inputA, inputB);
        carryOutMultiplexer = new TwoToOneMultiplexer(operationCode[0], fullAdder.getCarryOutput(), fullSubtractor.getBorrowOutput());

        s0_3 = new TwoToOneMultiplexer(operationCode[0], and.getOutput(), or.getOutput());
        s0_2 = new TwoToOneMultiplexer(operationCode[0], not.getOutput(), xor.getOutput());
        s0_1 = new TwoToOneMultiplexer(operationCode[0], fullAdder.getOutput(), fullSubtractor.getOutput());

        s1_0 = new TwoToOneMultiplexer(operationCode[1], s0_1.getOutput(), new LogicValue(0));
        s1_1 = new TwoToOneMultiplexer(operationCode[1], s0_3.getOutput(), s0_2.getOutput());

        s2_0 = new TwoToOneMultiplexer(operationCode[2], s1_1.getOutput(), s1_0.getOutput());
    }

    public void refresh(LogicValue opCode[], LogicValue cIn, LogicValue a, LogicValue b) {
        this.operationCode = opCode;
        this.carryInput = cIn;
        this.inputB = b;
        this.inputA = a;

        and.refresh(inputA, inputB);
        or.refresh(inputA, inputB);
        not.refresh(inputA, null);
        xor.refresh(inputA, inputB);

        fullAdder.refresh(carryInput, inputA, inputB);
        fullSubtractor.refresh(carryInput, inputA, inputB);
        carryOutMultiplexer.refresh(operationCode[0], fullAdder.getCarryOutput(), fullSubtractor.getBorrowOutput());

        s0_3.refresh(operationCode[0], and.getOutput(), or.getOutput());
        s0_2.refresh(operationCode[0], not.getOutput(), xor.getOutput());
        s0_1.refresh(operationCode[0], fullAdder.getOutput(), fullSubtractor.getOutput());

        s1_0.refresh(operationCode[1], s0_1.getOutput(), new LogicValue(0));
        s1_1.refresh(operationCode[1], s0_3.getOutput(), s0_2.getOutput());

        s2_0.refresh(operationCode[2], s1_1.getOutput(), s1_0.getOutput());
    }
}
