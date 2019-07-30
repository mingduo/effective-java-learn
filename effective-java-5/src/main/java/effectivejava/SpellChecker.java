package effectivejava;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 
 * @description:
 * @since 2019/7/29
 * @author : weizc 
 */

// Inappropriate use of singleton - inflexible & untestable!
public class SpellChecker {

    /**
     * 可以通过使 dictionary 属性设置为非 final ，
     * 并添加一个方法来更改现有拼写检查器中的字典，从而让拼
     * 写检查器支持多个字典，但是在并发环境中，
     * 这是笨拙的、容易出错的和不可行的。静态实用类和单例对于那些行为
     * 被底层资源参数化的类来说是不合适的
     */
    private final Map<String,Object>dictionary;

    public SpellChecker(Supplier<? extends Map> dictionary) {
        this.dictionary = dictionary.get();
    }

}
