package effectivejava;

import lombok.Builder;
import lombok.ToString;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class BuilderDemo {


    public static void main(String[] args) {

        Dog myDog = Dog.builder()
                .birth("2018-01-23").id(1L).name("柯基")
                .color("黄色").price("10")
                .build();
        System.out.println( myDog );
    }
}

@ToString
@Builder
class Dog {
    Long id;
    String name;

    String color;
    String price;

    String birth;
}
