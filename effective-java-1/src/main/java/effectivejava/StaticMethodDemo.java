package effectivejava;

import java.math.BigInteger;
import java.util.Random;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class StaticMethodDemo {

    public static void main(String[] args) {

        createBooleanInstance();

        createBigIntegerInstance();

    }

    private static void createBigIntegerInstance() {
        System.out.printf("BigInteger value is %s \n",BigInteger.ONE);
        System.out.printf("BigInteger value is %s \n",BigInteger.valueOf(15L));
        // 小于1024
        System.out.printf("BigInteger value is %s \n",BigInteger.probablePrime(10,new Random()));

    }

    private static void createBooleanInstance() {
        Boolean value = Boolean.valueOf("true");
        System.out.printf("Boolean value is %s \n",value);
    }



}
