package logic;

import cpu.programcounter.EightBitProgramCounter;
import cpu.alu.adder.FullAdder;
import cpu.alu.subtractor.FullSubtractor;
import logic.utils.LogicValueUtil;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public class Main {
    public static void main(String[] args) {
/*        LogicValue[] aluOutput = LogicValueUtil.getLogicValueArrayFromString("10101010");
        LogicValue[] dataBus = LogicValueUtil.getLogicValueArrayFromString("00000000");

        EightBitRegister register0 = new EightBitRegister();
        EightBitRegister register1 = new EightBitRegister();
        EightBitRegister register2 = new EightBitRegister();

        Memory aluMemory = register0;

        register0.input = aluOutput;
        register0.output = dataBus;

        register1.input = dataBus;
        register2.input = dataBus;

        register1.output = dataBus;
        register2.output = dataBus;

        aluMemory.set();
        aluMemory.enable();
        register1.set();

        LogicValueUtil.setLogicValueArrayFromString("11110000", aluOutput);

        aluMemory.set();
        aluMemory.enable();
        register2.set();

        LogicValueUtil.setLogicValueArrayFromString("00000000", aluOutput);
        aluMemory.set();
        aluMemory.enable();

        System.out.println(LogicValueUtil.getLogicValueArrayToString(dataBus));

        register1.enable();
        System.out.println(LogicValueUtil.getLogicValueArrayToString(dataBus));

        register2.enable();
        System.out.println(LogicValueUtil.getLogicValueArrayToString(dataBus));*/

        EightBitProgramCounter pc = new EightBitProgramCounter();
        int clock = 1;

        for(int i=0; i<100; i++) {

            pc.refresh(new LogicValue(1), new LogicValue(clock));
            String res = LogicValueUtil.getLogicValueArrayToString(pc.getOutput(), false);
            System.out.println(res + " " + getIntValFromBinString(res));

            try {
                Thread.sleep(1000);

                if(clock == 0) {
                    clock = 1;
                } else {
                    clock = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private static int getIntValFromBinString(String binString) {
        int ret = 0;

        for(int i=0; i<binString.length(); i++) {
            ret += ((binString.charAt(i) - 48) * Math.pow(2, i));
        }

        return ret;
    }

    public static LogicValue[] stringToArray(String binary) {
        LogicValue array[] = new LogicValue[binary.length()];

        for(int i=0; i<binary.length(); i++) {
            array[i] = new LogicValue(binary.charAt(i) - 48);
        }

        return array;
    }

    public static void _4BitSubtractor(String as, String bs) {
        int bit = 4;
        LogicValue borrowInput = new LogicValue(0);

        LogicValue[] a = stringToArray(as);
        LogicValue[] b = stringToArray(bs);

        FullSubtractor subtractor[] = new FullSubtractor[bit];

        for(int i=0; i<bit; i++) {
            subtractor[i] = new FullSubtractor(borrowInput, a[(bit-1)-i], b[(bit-1)-i]);
            borrowInput = subtractor[i].getBorrowOutput();
        }

        System.out.print(
                subtractor[3].getOutput().getValue() + "" +
                        subtractor[2].getOutput().getValue() + "" +
                        subtractor[1].getOutput().getValue() + "" +
                        subtractor[0].getOutput().getValue() + " C:" +
                        subtractor[3].getBorrowOutput().getValue());
    }

    public static void _4BitAdder(String as, String bs) {
        int bit = 4;
        LogicValue carryInput = new LogicValue(0);

        LogicValue[] a = stringToArray(as);
        LogicValue[] b = stringToArray(bs);

        FullAdder adder[] = new FullAdder[bit];

        for(int i=0; i<bit; i++) {
            adder[i] = new FullAdder(carryInput, a[(bit-1)-i], b[(bit-1)-i]);
            carryInput = adder[i].getCarryOutput();
        }

        System.out.print(
                adder[3].getOutput().getValue() + "" +
                adder[2].getOutput().getValue() + "" +
                adder[1].getOutput().getValue() + "" +
                adder[0].getOutput().getValue() + " C:" +
                adder[3].getCarryOutput().getValue());
    }
}
