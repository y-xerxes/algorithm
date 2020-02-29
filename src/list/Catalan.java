package list;

import java.util.*;
import java.math.BigInteger;

public class Catalan {
//    public static void main(String[] args) {
//        int numberOfCatalan = 101;
//        BigInteger[] digis = new BigInteger[numberOfCatalan];
//        digis = generateCatalan(numberOfCatalan);
//
//        Scanner scanner = new Scanner(System.in);
//
//        int number;
//
//        while (true) {
//            number = scanner.nextInt();
//            if (number == -1) {
//                break;
//            }
//            String answer = digis[number].toString();
//            System.out.println(answer);
//        }
//    }

//    static BigInteger[] generateCatalan(int numberOfCatalan) {
//        BigInteger digis[] = new BigInteger[numberOfCatalan + 1];
//        BigInteger x = new BigInteger("1");
//        digis[1] = x;
//        int y = 0;
//        int z = 0;
//        for (int counter = 2; counter <= numberOfCatalan; ++counter) {
//            y = 4 * counter - 2;
//            z = counter + 1;
//            digis[counter] = digis[counter - 1].multiply(new BigInteger("" + y));
//            digis[counter] = digis[counter].divide(new BigInteger("" + z));
//        }
//        return digis;
//    }

    public static double CatalanNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return CatalanNumber(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<=50; i++) {
            System.out.println(i + "'s Catalan Number is " + CatalanNumber(i));
        }
    }
}