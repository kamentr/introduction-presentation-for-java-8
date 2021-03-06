package introduction.java.features.presentation.streams.function.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private double weight;
    private int age;
    private String preferredGenderPronoun;

    public static boolean isJavaDeveloper(Person person) {
        return true;
    }
}
