package introduction.java.features.presentation.streams.infinity;


import java.util.stream.Stream;

/**
 * Streams can be:
 * * Ordered or unordered
 * * Distinct or Non-distinct
 * * Sized or infinite
 */
public class InfiniteStreams {

    public static void main(String[] args) {
        infiniteStream();
        howAreInfiniteStreamsUseful();
    }

    /**
     * Try to guess what will this print out.
     */
    private static void infiniteStream() {
        // Start from 1 and add 1 to infinity
        System.out.println(Stream.iterate(1, (number -> number + 1)));
    }

    private static void howAreInfiniteStreamsUseful() {
        // Given a number k, and a count n, find the total of the double of n
        // even numbers starting with k, where sqrt of each number is > 20

        int k = 121;
        int n = 20;

        // Lets try to solve it imperatively first
        System.out.println(imperativeSolution(k, n));

        // That didn't work out very well...
        // Now lets try declarative solution
        System.out.println(declarativeSolution(k, n));
    }

    private static int imperativeSolution(int k, int n) {
        int result = 0;
        int index = k;
        int count = 0;

        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count++;
            }
            index++;
        }
        return result;
    }

    private static int declarativeSolution(int k, int n) {
        return Stream.iterate(k, number -> number + 1)
                .filter(number -> number % 2 == 0)
                .filter(number -> Math.sqrt(number) > 20)
                .mapToInt(number -> number * 2)
                .limit(n)
                .sum();
    }
}
