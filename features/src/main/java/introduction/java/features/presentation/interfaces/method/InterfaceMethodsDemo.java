package introduction.java.features.presentation.interfaces.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterfaceMethodsDemo {

    public static void main(String[] args) {
        EmixisTeam fsrTeam = new FsrTeam();
        EmixisTeam liveTeamTeam = new LiveTeam();

        // Default methods
        log.info(fsrTeam.getTeamName());
        log.info(liveTeamTeam.getTeamName());

        // Static methods
        String teamName = EmixisTeam.getProjectName();
        log.info(teamName);
    }

    /* Some notes:
    * - Constants in an interface (generally bad)
    *   - Exceptions:
    *       - "If the constants are strongly tied to an existing class or interface, you should add them
            to the class or interface. For example, all of the boxed numerical primitive
            classes, such as Integer and Double, export MIN_VALUE and
            MAX_VALUE constants."
                                           * Effective Java - Item 22 Use interfaces only to define types
    * */


}
