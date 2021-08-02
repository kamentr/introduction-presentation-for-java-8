package introduction.java.features.presentation.streams.parallel.helper;

public class SlowMethod {
    
    private SlowMethod() {
        throw new RuntimeException("Don't make instances of me");
    }

    public static final int ONE_SECOND = 1000;

    public static int oneSecond(int number) {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
