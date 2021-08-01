package introduction.java.features.presentation.streams.parallel;

import introduction.java.features.presentation.streams.parallel.helper.SlowMethod;
import introduction.java.features.presentation.streams.parallel.helper.TimeIt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Parallel programming is made super easy with Streams
 * instead of using .stream()
 * just use .parallelStream()
 */
public class Parallel {


    /**
     * Parallelizing a block of code can make it run much faster
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        TimeIt.code(
                () -> numbers.stream()
                        .map(SlowMethod::OneSecond)
                        .collect(Collectors.toList())
        );
    }

    /*
     * Just because we can does not mean we should!
     *
     * Using parallel streams might be very fast for this particular piece of code
     * however the "parallelStream()" call initiates a lot of resources to be that fast.
     * This means that other processes might be slowed down or even stopped temporarily
     * until this process is finished. */

    /*
     * Never prematurely try to optimize code!
     *
     * Never write code with performance in mind first.
     * Clean code practices say this:
     * 1. First make it work.
     * 2. Refactor. Make it simple, make it readable.
     * 3. ONLY IF NECESSARY optimize.
     * */

    /*
     * Parallelizing is useful only when:
     * 1. The amount of data is big
     * 2. You need the result fast, no matter what
     * 3. The problem is parallelizable in the first place (can be divided in chunks of work)
     * 4. You've tested rigorously the performance of the application and have
     * proof that using parallel is faster
     * */
}
