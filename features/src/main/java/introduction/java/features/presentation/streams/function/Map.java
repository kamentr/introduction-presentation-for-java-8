package introduction.java.features.presentation.streams.function;


import introduction.java.features.presentation.streams.function.helper.Data;
import introduction.java.features.presentation.streams.function.helper.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Map transforms values
 * The number of input elements = the number of output elements
 * No guarantee of the Type of the output with respect to the type of the input
 * Map takes a Function<T, R> and returns Stream<R>
 */
public class Map {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob Sinatra", "Snoop Dog", "Patrick Star", "Jean Well", "Monica Wilson");

        names.stream()
                .map(name -> name.split(SPACE)[0])
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 34, 4, 2, 77, 3, 31, 6);

        System.out.println(
                numbers.stream()
                        .mapToLong(Long::valueOf)
                        .mapToDouble(number -> number * 2.0)
                        .map(Math::floor)
                        .sum() // .average() .max() .min()
        );

        // Some more realistic examples
        List<Person> people = Data.getListOfPeople();

        System.out.println(
                people.stream()
                        .mapToDouble(Person::getWeight)
                        .sum()
        );

        System.out.println(
                people.stream()
                        .map(Person::getAge)
                        .filter(age -> age >= 18)
                        .count()
        );

        System.out.println(
                people.stream()
                        .map(Person::getName)
                        .filter(name -> name.equals("Snoop Dog"))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Where is Snoop Dog?"))
        );

    }

}
