package introduction.java.features.presentation.interfaces.functional;

import java.util.function.Predicate;

public class PredicateExample implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return false;
    }
}
