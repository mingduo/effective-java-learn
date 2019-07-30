package effectivejava;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : weizc
 * @description:
 * @since 2019/7/30
 */
public class tryCatchDemo {


    public static void main(String[] args) {
        /**
         *在处理必须关闭的资源时，使用 try-with-resources 语句替代 try-finally 语句。
         *  生成的代码更简洁，
         * 更清晰，并且生成的异常更有用。
         * try-with-resources 语句在编写必须关闭资源的代码时会更容易，也不会出错，而
         * 使用 try-finally 语句实际上是不可能的。
         */
    }

    // try-finally - No longer the best way to close resources!
    static String firstLineOfFileByTryCatch(String path) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }


    // try-with-resources - the the best way to close resources!
    static String firstLineOfFileByTryResource(String path) throws IOException {
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get(path));
        ) {
            return br.readLine();
        }

    }


    // try-with-resources on multiple resources - short and sweet
    static void copyByTryResource(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buf = new byte[1024];
            int i;
            while ((i = in.read(buf)) > 0) {
                out.write(buf, 0, i);
            }
        }
    }


    // try-finally is ugly when used with more than one resource!
    static void copyByTryCatch(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
