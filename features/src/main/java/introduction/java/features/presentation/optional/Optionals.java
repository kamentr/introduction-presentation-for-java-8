package introduction.java.features.presentation.optional;

import introduction.java.features.presentation.streams.function.helper.Data;
import introduction.java.features.presentation.streams.function.helper.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class Optionals {

    public static void main(String[] args) {
        whatIsOptional();
        whyAreOptionalsUseful();
        howToWorkWithOptionals();
    }

    /**
     * Optional is the abstraction of uncertainty that Java 8 provides.
     * We use Optional<T> when we are not sure an answer exists
     */
    private static void whatIsOptional() {
        Optional<Object> emptyOptional = Optional.empty(); // represents null

        // Returns an Optional with the specified present non-null value.
        // Throws NullPointerException if param is null
        Optional<Long> optionalLong = Optional.of(68L);

        // Returns an Optional describing the specified value, if non-null,
        // otherwise returns an empty Optional.
        Optional.ofNullable(methodThatMightReturnNull());

        if (optionalLong.isPresent()) {
            System.out.println("So close... " + optionalLong.get());
        }
    }

    /**
     * Optionals are primarily used for explicitly declaring that our code
     * may produce empty result.
     * On the recieving end our clients are then 'forced' to solve for Optional.
     */
    private static void whyAreOptionalsUseful() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 6, 11, 33);

        // Find the double of the first number that is even and greater than 3
        System.out.println(imperativeSolution(numbers));
        System.out.println(declarativeSolution(numbers));
    }

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

    private static Optional<Integer> declarativeSolution(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .filter(number -> number > 3)
                .map(result -> result * 2)
                .findFirst();
    }

    private static void howToWorkWithOptionals() {
        List<Person> people = Data.getListOfPeople();

        Optional<Person> anyOldPerson = people.stream()
                .filter(person -> person.getAge() > 18)
                .findAny();

        if (anyOldPerson.isPresent()) {
            System.out.println("You can watch the scary movie!");
        }

        List<String> allThePeopleWhoHavePreferredPronouns = people.stream()
                .map(person -> Optional.ofNullable(person.getPreferredGenderPronoun()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<String> allThePeopleWhoHavePreferredPronounsOrDefault = people.stream()
                .map(person -> Optional.ofNullable(person.getPreferredGenderPronoun()))
                .map(pronoun -> pronoun.orElse("He/She"))// Return the value ifPresent orElse return 'He/She'
                .collect(Collectors.toList());

        System.out.println(allThePeopleWhoHavePreferredPronouns);
        System.out.println(allThePeopleWhoHavePreferredPronounsOrDefault);

        Optional<String> reactDeveloper = Optional.of(findPersonWithReactKnowleadge());
        reactDeveloper.ifPresent(Optionals::callManager);
    }

    private static void callManager(String developerName) {
        System.out.println("Calling " + developerName + "'s manager...");
    }

    private static String findPersonWithReactKnowleadge() {
        return "Eww.. that's not Java??";
    }

    private static Object methodThatMightReturnNull() {
        Random random = new Random();
        boolean isNull = random.nextBoolean();
        return isNull ? null : new Object();
    }
}
