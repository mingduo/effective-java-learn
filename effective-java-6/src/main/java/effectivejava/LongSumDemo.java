package effectivejava;

import org.springframework.util.StopWatch;

/**
 * 
 * @description:
 * @since 2019/7/29
 * @author : weizc 
 */
public class LongSumDemo {


    public static void main(String[] args) {
        StopWatch sw=new StopWatch("LongSumDemo");
        sw.start("uselongSum");
        uselongSum();
        sw.stop();
        /**
         * ：优先使用基本类型而不是装箱的基本类型，也要注意无意识的自动装箱
         */

        sw.start("useLongSum");
        useLongSum();
        sw.stop();

        System.out.println(sw.prettyPrint());

    }

    private static  Long uselongSum(){

        long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        return sum;
    }

    private static  Long useLongSum(){

        Long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        return sum;

    }
}
