package introduction.java.features.presentation.interfaces.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterfaceMethodsDemo {

    public static void main(String[] args) {
        WorkingPlace fsrWorkingPlace = new FsrTeam();
        WorkingPlace liveTeamWorkingPlace = new LiveTeam();

        // Default methods
        log.info(fsrWorkingPlace.getWorkingPlace());
        log.info(liveTeamWorkingPlace.getWorkingPlace());

        // Static methods
        String teamName = WorkingPlace.getTeamName();
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
