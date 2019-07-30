package effectivejava;

import lombok.Data;

/**
 * 
 * @description:
 * @since 2019/7/29
 * @author : weizc 
 */
public class FinalizerDemo {
    public static void main(String[] args) {

        {
            User user = new User();

        }
    }


    @Data
    private static class  User extends Object{
        String name;

        @Override
        protected void finalize() throws Throwable {
            System.out.println("请不要使用 finalize 方法");

            super.finalize();
        }
    }
}

