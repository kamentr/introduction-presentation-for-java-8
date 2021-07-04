package introduction.java.features.presentation.interfaces.functional;


import java.util.Arrays;
import java.util.List;

public class DemoMain {
/*

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

    public static void main(String[] args) {
        List<String> javaDevelopers = Arrays.asList("Plamena", "Lyubo", "Kamen");

        CustomFunctionalInterface printer = System.out::println;

    }
}
