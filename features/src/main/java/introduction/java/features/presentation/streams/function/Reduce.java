package introduction.java.features.presentation.streams.function;

import java.util.Arrays;
import java.util.List;

/**
 * Reduce brings values together <3
 */
public class Reduce {

  public static void main(String[] args) {
    simpleReduceExample();
    specializedReduces();
  }

  private static void simpleReduceExample() {
    List<Integer> numbers = Arrays.asList(1, 34, 4, 2, 77, 3, 31, 6);

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .map(number -> number * 2)
            // Reduce receives initial value of 0
            // Then our "carry" is initialized with this initial value
            // And then we write the implementation of the 'accumulator'
            .reduce(0, (carry, number) -> carry + number)
    );
    /** That is too complicated we rarely use 'custom' reduces :) */
  }

  /**
   * No need for documentation ;) Declarative style got you covered
   */
  private static void specializedReduces() {
    List<Integer> numbers = Arrays.asList(1, 34, 4, 2, 77, 3, 31, 6);

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToDouble(number -> number * 2)
            .sum()
    );

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToDouble(number -> number * 2)
            .max()
    );

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToDouble(number -> number * 2)
            .min()
    );

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToDouble(number -> number * 2)
            .average()
    );

    System.out.println(
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .mapToDouble(number -> number * 2)
            .count()
    );
  }
}
