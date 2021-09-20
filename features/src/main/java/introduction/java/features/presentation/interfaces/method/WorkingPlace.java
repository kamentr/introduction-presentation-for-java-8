package introduction.java.features.presentation.interfaces.method;

public interface WorkingPlace {

    static String getTeamName() {
        return "Emixis";
    }

    default String getWorkingPlace() {
        return "We work at Emixis by default";
    }
}
