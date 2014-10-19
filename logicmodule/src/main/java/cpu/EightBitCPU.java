package cpu;

import cpu.alu.EightBitAlu;
import memory.EightBitRegister;

/**
 * Created by Piotr Kulma on 04.10.14.
 */
public class EightBitCPU {
    private EightBitAlu alu;

    //general purpose registers
    private EightBitRegister r0;
    private EightBitRegister r1;
    private EightBitRegister r2;

    //accumulator
    private EightBitRegister a;
    //input b temp
    private EightBitRegister b;

    //state register
    private EightBitRegister flag;

    //instruction register
    private EightBitRegister instr;

    //next instruction address register
    private EightBitRegister instrAddr;

    //ram address to save data
    private EightBitRegister memoryAddr;

    private ControlUnit controlUnit;
}
