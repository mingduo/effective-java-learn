package effectivejava;

/**
 * 
 * @description:
 * @since 2019/7/30
 * @author : weizc 
 */
public class EqualOverrideDemo {

    public static void main(String[] args) {
        /**
         * 自反性： 对于任何非空引用 x， x.equals(x) 必须返回 true。
         * 对称性： 对于任何非空引用 x 和 y，如果且仅当 y.equals(x) 返回 true 时 x.equals(y) 必须返回 true。
         * 传递性： 对于任何非空引用 x、y、z，如果 x.equals(y) 返回 true， y.equals(z) 返回 true，则
         * x.equals(z) 必须返回 true。
         * 一致性： 对于任何非空引用 x 和 y，如果在 equals 比较中使用的信息没有修改，则 x.equals(y) 的多次调用
         * 必须始终返回 true 或始终返回 false。
         * 对于任何非空引用 x， x.equals(null) 必须返回 false。
         */
    }
}
