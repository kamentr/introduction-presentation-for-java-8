package introduction.java.features.presentation.interfaces.method;

public interface EmixisTeam {

    static String getProjectName() {
        return "Emixis";
    }

    default String getTeamName() {
        return "DigIt";
    }
}
