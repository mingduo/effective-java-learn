package effectivejava;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @description:
 * @since 2019/7/30
 * @author : weizc 
 */
public class CompareToAndEqualsDemo {


    public static void main(String[] args) throws CloneNotSupportedException {
        // 比较 依赖于equals 方法
        printSetValue(new HashSet<>());
        //依赖于compare方法
        printSetValue(new TreeSet<>());
    }

    private static void printSetValue(Set<BigDecimal> set) {

        set.add(BigDecimal.valueOf(1.0D));
        set.add(BigDecimal.valueOf(1));

        System.out.printf("set 's size : %d ,set : %s \n",set.size(),set);
    }


}
