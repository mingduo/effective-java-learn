package effectivejava;

import lombok.Builder;
import lombok.ToString;

/**
 * 
 * @description:
 * @since 2019/7/30
 * @author : weizc 
 */
public class UseToStringDemo {
    public static void main(String[] args) {
        System.out.println(Axe.builder().name("fw").build().toString());
    }
}

@ToString
@Builder
class Axe{
    String name;
}