package effectivejava;

import java.sql.Types;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class CommonStaticMethodDemo {

    public static void main(String[] args) {


        showTypes();

        showCollections();

        showEnumSet();
    }

    private static void showTypes() {
        System.out.println("types list = " +    Arrays.asList(Types.ARRAY,Types.BOOLEAN) );
    }

    private static void showCollections() {
        List<Object> emptyList = Collections.emptyList();

        System.out.println("list :"+emptyList);
        List<Integer> numbers = Collections.unmodifiableList(List.of(1, 2, 3));
        System.out.println("list :"+numbers);

    }


    private static void showEnumSet(){

        /**
         * 如果大多数枚举类型具有 64 个或更少的元素，静态工厂将返回一个
         * RegularEnumSet 实例， 返回一个 long 类型；
         * 如果枚举类型具有六十五个或更多元素，则工厂将返回一个
         * JumboEnumSet 实例，返回一个 long 类型的数组
         */
        Set<TimeUnit> timeUnits = EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS);
        System.out.println("EnumSet :"+timeUnits);
        System.out.println("EnumSet class :"+timeUnits.getClass());

        System.out.println("EnumSet :"+EnumSet.allOf(Thread.State.class));

    }


}
