package introduction.java.features.presentation.streams.parallel.helper;

public class SlowMethod {

    public static final int ONE_SECOND = 1000;

    public static int OneSecond(int number) {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
