package introduction.java.features.presentation.streams.parallel.helper;

public class SlowMethod {

    public static final int ONE_SECOND = 1000;

    private SlowMethod() {
        throw new RuntimeException("Don't make instances of me");
    }

    public static int oneSecond(int number) {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
