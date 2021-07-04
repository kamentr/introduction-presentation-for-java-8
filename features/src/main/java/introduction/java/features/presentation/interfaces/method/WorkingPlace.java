package introduction.java.features.presentation.interfaces.method;

public interface WorkingPlace {

    default String getWorkingPlace() {
        return "We work at Emixis by default";
    }

    static String getTeamName() {
        return "Emixis";
    }
}
