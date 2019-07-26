package effectivejava;

import java.lang.reflect.Field;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class aa {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s="Abc";

        String value2 = new String("Hello");

        // 从 Java 1.5 开始对象属性可以通过反射修改
        char[] chars = "Hello World".toCharArray();
        // 获取 String 类中的 value 字段
        Field valueField = String.class.getDeclaredField("value");
        // 设置 private 字段可以被修改
        valueField.setAccessible(true);
        // 把 chars 设置到 value 字段的内容
        valueField.set(value2, chars);

        System.out.println("s = [" + s + "]");
    }
}
