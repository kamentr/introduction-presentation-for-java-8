package introduction.java.features.presentation.streams.function.helper;

import java.util.Arrays;
import java.util.List;

public class Data {

    private Data() {
    }

    public static List<Person> getListOfPeople() {
        Person stella = new Person("Miss Stella", 33.3, 10);
        Person bob = new Person("Bob Sinatra", 99, 44);
        Person snoop = new Person("Snoop Dog", 50, 78);
        Person patrick = new Person("Patrick Star", 3, 2);
        Person jean = new Person("Jean Well", 80, 21);
        Person monica = new Person("Monica Wilson", 32, 55);

        return Arrays.asList(stella, bob, snoop, patrick, jean, monica);
    }

}


