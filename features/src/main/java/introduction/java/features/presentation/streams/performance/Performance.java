package introduction.java.features.presentation.streams.performance;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * Streams might be pretty but are they fast?
 */
public class Performance {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(imperativeSolution(numbers));
        System.out.println(declarativeSolution(numbers));
    }

    // How many units of work does it take to reach result?
    private static int imperativeSolution(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            if (number > 3 && number % 2 == 0) {
                result = number * 2;
                break;
            }
        }

        return result;
    }

    /**
     * Streams are using Lazy Evaluation
     * They build a "function pipeline" of the functions you've provided
     * and then wait for something to trigger execution
     */
    private static Optional<Integer> declarativeSolution(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .filter(number -> number > 3)
                .map(result -> result * 2)
                .findFirst(); // trigger
    }

    /*
     * Summary:
     * 1. With or without streams we can expect more or less the same speed
     * 2. Because of Lazy Evaluation there might be scenarios where the "stream" code is not executed (which is faster than executing it :) )
     * 3. The performance of one peace of code vastly depends on its simplicity.
     * Since the Java Compiler will try to "understand" your code and optimise it.
     * Therefore simple code = fast code. */

    /*
     * Quote from "Java Performance - In-Depth Advice for Tuning and Programming Java 8, 11, and Beyond by Scott Oaks"
     *
     * The simpler the code, the more optimizations that can be performed on it. Profile
     * feedback and escape analysis can yield much faster code, but complex loop structures
     * and large methods limit their effectiveness.
     */
}
