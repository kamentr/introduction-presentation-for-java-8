package introduction.java.features.presentation.streams.function;

import introduction.java.features.presentation.streams.function.helper.Data;
import introduction.java.features.presentation.streams.function.helper.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Reduce brings values together <3
 */
@SuppressWarnings("ALL")
public class Reduce {

    public static void main(String[] args) {
        simpleReduceExample();
        specializedReduces();
        collectors();
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
        List<Person> people = Data.getListOfPeople();

        System.out.println(
                people.stream()
                        .mapToDouble(Person::getWeight)
                        .sum()
        );

        System.out.println(
                people.stream()
                        .filter(Person::isJavaDeveloper)
                        .mapToDouble(Person::getAge)
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

    /**
     * Collectors are also reducers
     * we are creating one collection from many objects
     */
    private static void collectors() {
        List<Integer> numbers = Arrays.asList(1, 34, 4, 2, 77, 3, 31, 6);
        List<Person> people = Data.getListOfPeople();

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(toList());

        // All the numbers without duplication
        // However this is for educational purposes only
        // For this we should use 'distinct'
        Set<Integer> distinctNumbers = numbers.stream()
                .collect(Collectors.toSet());

        Map<String, Integer> nameAgePair = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        // Create a map where the key is Age
        // and the value is all the people with that age
        Map<Integer, List<Person>> peopleGroupedByAge = people.stream()
                .collect(groupingBy(Person::getAge));

        // Create a map where the key is Age
        // and the value is all the people's names with that age
        Map<Integer, List<String>> namesGroupedByAge = people.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
    }
}
