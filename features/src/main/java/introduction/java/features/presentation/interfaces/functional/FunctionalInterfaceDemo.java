package introduction.java.features.presentation.interfaces.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class FunctionalInterfaceDemo {
    /*

            * Functional Interfaces are interfaces which represent some functionality
              (Instead of representing data)

            * They have a single abstract method

            # Some examples from Java 7 #

                public interface Runnable {
                    void run();
                }

                public interface Callable<V> {
                    V call();
                }

                public interface Comparator<T> {
                    int compare(T o1, T o2);
                }

            # Functional Interfaces help enable Lambdas in Java 8

            -----------------------------------------------------------------------------
            // This
            Comparator<User> comparator = new Comparator<User>() {
                @Override
                public void int compare(User u1, User u2) {
                    return u1.getName().compareTo(u2.getName());
                }
            }

            // becomes this...
            Comparator<User> comparator =
                (userOne, userTwo) -> userOne.getName().compareTo(userTwo.getName());
            -----------------------------------------------------------------------------


            Functional Interfaces are heavily used in streams:
            -----------------------------------------------------------------------------

     */

    // Just a helper method
    private static List<User> getUsersFromSomewhere() {
        return Arrays.asList(new User(), new User());
    }

    /* -----------------------------------------------------------------------------


       * There are forty-three interfaces in java.util.Function.
       * Here are six of them (most common ones), the others can be derived from these.

       Best practice:
           * If one of the standard functional interfaces does the job, you should
           * generally use it in preference to a purpose-built functional interface.

       -----------------------------------------------------------------
       Interface               Signature             Example
       -----------------------------------------------------------------
       UnaryOperator<T>        T apply(T t)          String::toLowerCase
       BinaryOperator<T>       T apply(T t1, T t2)   BigInteger::add
       Predicate<T>            boolean test(T t)     Collection::isEmpty
       Function<T,R>           R apply(T t)          Arrays::asList
       Supplier<T>             T get()               Instant::now
       Consumer<T>             void accept(T t)      System.out::println
       -----------------------------------------------------------------
*/

    public void functionalInterfacesInStreamsExample() {
        List<User> users = getUsersFromSomewhere();

        // the old way (eww)
        users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.isPasswordGenerated();
            }
        });

        // the new way
        users.removeIf(user -> {
            return user.isPasswordGenerated();
        });

        // even better
        users.removeIf(user -> user.isPasswordGenerated());

        // the best <3
        users.removeIf(User::isPasswordGenerated);
    }
}
