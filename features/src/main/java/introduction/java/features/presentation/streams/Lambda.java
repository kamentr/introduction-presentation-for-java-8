package introduction.java.features.presentation.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Lambda {

    public static void main(String[] args) {
        backwardsCompatibility();
    }

    /**
     * Lambdas are backwards compatible
     * Thread class has been around since JDK 1.0
     * And is still working with Lambdas introduced in JDK 8
     */
    private static void backwardsCompatibility() {
        Thread veryOldThread = new Thread(() -> log.info("The future is now old man."));

        veryOldThread.start();
    }

    /**
     * Here we will observe on of the best features of Java 8 -
     * the Lambdas.
     * For this example we will also use the new forEach method
     * provided for every class that implements Iterable
     */
    private void iterations() {
        List<Integer> numbers = Arrays.asList(4, 64, 9, 11, 3, 420);

        /* Old way:
         * Complex, verbose, many ways to mess up
         * Do not mistake "familiar" with "simple" */

        // External iterator
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Number: " + numbers.get(i));
        }

        /* Better but still...
         * Another external iterator */
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }

        /* Nice!
         * Internal iterator
         * Get the pros from Polymorphism, call the implementation from the object itself
         * The implementation details are hidden (as it should be)*/
        numbers.forEach((Integer number) -> System.out.println("Number: " + number));

        /* Java 8 has type inference (meaning the type of the parameter can be removed) */
        numbers.forEach(number -> System.out.println("Number: " + number));

        /* Take advantage of method reference when you can */
        numbers.forEach(System.out::println);

        /* You can also pass your own custom methods */
        numbers.forEach(this::incrementAndPrint);
    }

    /**
     * Clean code practices:
     * Lambdas must be kept small!
     * - Whenever you need to add '{}' to the lambda's body consider extracting a method
     * - Lambdas should always be oneliners
     * - Think of Lambdas as "Glue code"
     * Disobeying these rules will lead to code that is:
     * - Hard to read
     * - Noisy/Cluttered, because of the syntax of Lambdas it is unavoidable
     * - Leads to duplication, whatever you have in that multiline code it is not reusable
     * - Hard to test with Unit Tests
     */
    private void incrementAndPrint(Integer number) {
        if (number % 2 == 1) {
            number = number * 3 + 1;
        }

        System.out.println("Number: " + number);
    }
}



