package introduction.java.features.presentation.streams.function;

import java.util.Arrays;
import java.util.List;

/**
 * Filters as expected filter objects
 * given a Predicate function
 */
public class Filter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 64, 9, 11, 3, 420);

        /* Imagine we need all the even numbers from a list of Integers to do some calculation on them
         * The imperative way would look something like this */

        /* Even though this is a simple example it is still
         * a bit hard to understand what is going on from a glance,
         * your eyes have to go up and down (aka spaghetti code) and we have the added complexity
         * from using "external iterator"
         * */
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                doSomeCalculation(number);
            }
        }

        /* Here the code can be read line by line like a book
         * It is very easy to find the key components of the operation
         * This is called declarative style of programming
         * */
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(Filter::doSomeCalculation);
    }

    private static void doSomeCalculation(Integer number) {
        number += 100;
        System.out.println(number);
    }

}
