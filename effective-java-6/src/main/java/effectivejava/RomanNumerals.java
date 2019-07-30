package effectivejava;

import org.springframework.util.StopWatch;

import java.util.regex.Pattern;

/**
 * 
 * @description:
 * @since 2019/7/29
 * @author : weizc 
 */

// Reusing expensive object for improved performance
public class RomanNumerals {

    private static final Pattern ROMAN=Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    // Performance can be greatly improved!
    static boolean isRomanNumeralBefore(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }



    public static void main(String[] args) {
        StopWatch stopWatch=new StopWatch(RomanNumerals.class.getSimpleName());

        stopWatch.start("isRomanNumeral");
        isRomanNumeral("abc");
        stopWatch.stop();


        stopWatch.start("isRomanNumeralBefore");
        isRomanNumeralBefore("abc");
        stopWatch.stop();


        System.out.println(stopWatch.prettyPrint());

    }


}
