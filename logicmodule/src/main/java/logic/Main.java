package logic;

import alu.adder.FullAdder;
import alu.subtractor.FullSubtractor;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public class Main {
    public static void main(String[] args) {
        _4BitAdder("0001", "0001");
        System.out.println();
        _4BitAdder("1001", "0001");
        System.out.println();
        _4BitAdder("1111", "1111");
        System.out.println();
        _4BitSubtractor("1001", "1111");

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
