package effectivejava;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description:
 * @since 2019/7/26
 * @author : weizc 
 */
public class CommonStaticMethodExampleDemo {

    public static void main(String[] args) throws IOException {

        //类型转换方法

        Date now = Date.from(Instant.now());

        printInfo(now);

        Set<TimeUnit> javaKinds = EnumSet.allOf(TimeUnit.class);

        printInfo(javaKinds);

        printInfo(Array.newInstance(Integer.TYPE,1));


        Path path = Paths.get(System.getProperty("user.dir"));
        printInfo(Files.getFileStore(path));
        path = Paths.get(System.getProperty("user.dir")+File.separator+"README.md");

        printInfo(Files.newBufferedReader(path));

        StringTokenizer tokenizer = new StringTokenizer("1,2,3",",");
        printInfo(Collections.list(tokenizer));
    }

    private static void printInfo(Object obj) {
        System.out.printf("info = [%s] , class = [%s] \n" ,obj,obj.getClass() );
    }


}
