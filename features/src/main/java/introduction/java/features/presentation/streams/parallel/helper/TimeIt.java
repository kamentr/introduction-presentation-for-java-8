package introduction.java.features.presentation.streams.parallel.helper;

public class TimeIt {

    private TimeIt() {
    }

    public static void code(Runnable block) {
        long start = System.nanoTime();

        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken in seconds: " + (end - start) / 1.0e9);
        }
    }
}
