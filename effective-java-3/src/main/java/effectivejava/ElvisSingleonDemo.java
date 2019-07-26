package effectivejava;

import lombok.ToString;

import java.util.function.Supplier;

/**
 * @author : weizc
 * @description:
 * @since 2019/7/26
 */
public class ElvisSingleonDemo {


    public static void main(String[] args) {
        System.out.println(Elvis.ELVIS_INSTANCE);


        Supplier<Elvis2> instance = Elvis2::getInstance;
        System.out.println(instance.get());


        System.out.println(Elvis3.ELVIS_3);

    }
}

@ToString
class Elvis {

    public static final Elvis ELVIS_INSTANCE = new Elvis("hk");


    String name;


    private Elvis(String name) {
        this.name = name;
    }
}

@ToString
class Elvis2 {

    private static final Elvis2 ELVIS_INSTANCE = new Elvis2("ha");


    String name;


    private Elvis2(String name) {
        this.name = name;
    }

    public static Elvis2 getInstance() {
        return ELVIS_INSTANCE;
    }
}

@ToString
enum Elvis3 {

    ELVIS_3("ABC");

    String name;


    private Elvis3(String name) {
        this.name = name;
    }


}