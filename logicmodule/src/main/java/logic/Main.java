package logic;

import logic.adder.FullAdder;
import logic.gate.NOTGate;
import logic.subtractor.FullSubtractor;
import logic.subtractor.HalfSubtractor;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public class Main {
    public static void main(String[] args) {
        //_4BitAdder("0001", "0001");
        //_4BitSubtractor("1001", "1111");
        //HalfSubtractor hs = new HalfSubtractor(1, 0);
    }

    public static int[] stringToArray(String binary) {
        int array[] = new int[binary.length()];

        for(int i=0; i<binary.length(); i++) {
            array[i] = (binary.charAt(i) - 48);
        }

        return array;
    }

    public static void _4BitSubtractor(String as, String bs) {
        int bit = 4;
        int borrowInput = 0;

        int[] a = stringToArray(as);
        int[] b = stringToArray(bs);

        FullSubtractor subtractor[] = new FullSubtractor[bit];

        for(int i=0; i<bit; i++) {
            subtractor[i] = new FullSubtractor(borrowInput, a[(bit-1)-i], b[(bit-1)-i]);
            borrowInput = subtractor[i].getBorrowOutput();
        }

        System.out.print(
                subtractor[3].getOutput() + "" +
                        subtractor[2].getOutput() + "" +
                        subtractor[1].getOutput() + "" +
                        subtractor[0].getOutput() + " C:" +
                        subtractor[3].getBorrowOutput());
    }

    public static void _4BitAdder(String as, String bs) {
        int bit = 4;
        int carryInput = 0;

        int[] a = stringToArray(as);
        int[] b = stringToArray(bs);

        FullAdder adder[] = new FullAdder[bit];

        for(int i=0; i<bit; i++) {
            adder[i] = new FullAdder(carryInput, a[(bit-1)-i], b[(bit-1)-i]);
            carryInput = adder[i].getCarryOutput();
        }

        System.out.print(
                adder[3].getOutput() + "" +
                adder[2].getOutput() + "" +
                adder[1].getOutput() + "" +
                adder[0].getOutput() + " C:" +
                adder[3].getCarryOutput());
    }
}
