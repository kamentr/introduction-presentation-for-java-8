package introduction.java.features.presentation.streams.study;

import java.util.Arrays;
import java.util.List;


/**
 * A study was made to test the readability of both
 * imperative and declarative styles of programming.
 * Programmers were asked to read both pieces of code and
 * try to answer what the code will produce
 */
public class ImperativeVsDeclarative {

    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        imperative();
        declarative();
    }

    /**
     * For imperative style the programmers took on average 85 seconds to answer
     */
    private static void imperative() {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 5 && isEven(numbers.get(i)) && numbers.get(i) < 9 && numbers.get(i) * 2 > 15) {
                result = numbers.get(i);
                break;
            }
        }

        System.out.println(result);
    }

    /**
     * For declarative style the programmers took on average 55 seconds to answer
     */
    private static void declarative() {
        int result = numbers.stream()
                .filter(number -> number > 5)
                .filter(number -> isEven(number))
                .filter(number -> number < 9)
                .filter(number -> number * 2 > 15)
                .findFirst()
                .get();

        System.out.println(result);
    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }
}
