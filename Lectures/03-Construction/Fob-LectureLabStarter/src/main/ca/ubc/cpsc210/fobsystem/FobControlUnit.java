package ca.ubc.cpsc210.fobsystem;

import java.util.*;

/**
 * This class represents a box that can be attached to a resource, such
 * as a door, and used to grant or deny access to a user with a fob.
 *
 * @author Gail Murphy
 */

public class FobControlUnit {

    // Internal representation must store users and their related fobs.
    // If the fob and user are stored, then the fob has access to the resource.
    private Map<Fob, User> accessControl;
    List<Fob> fobs;
    List<User> users;

    /**
     * Constructor
     */
    public FobControlUnit() {
        accessControl = new HashMap<>();

    }

    /**
     * Initialize which fobs have access to the protected resource.
     * In a real implementation of such a system, this method would
     * likely be called from the constructor and might read from
     * a web service. We'll just pass the information for simplicity
     * and ease of testing.
     *
     * @param fobs  the fobs to grant access
     * @param users the user of each fob
     *              <p>
     *              Modifies: this
     *              Effects: Stores the fobs and users.
     *              Throws an IllegalValuesException if the fobs and users lists
     *              are not the same size
     */
    public void initializeFobs(List<Fob> fobs, List<User> users) throws IllegalValuesException {
        if (fobs != null && users != null) {
            if (fobs.size() != users.size())
                throw new IllegalValuesException();
            else {
                for (int i = 0; i < fobs.size(); i++) {
                    accessControl.put(fobs.get(i), users.get(i));
                }
            }
        }
    }

    /**
     * Does this fob have access? If so, record having granted access.
     *
     * @param fob The fob to check
     * @return true if the fob has access and false otherwise
     */
    public boolean hasAccess(Fob fob) {
        if (fob != null) {
            if (accessControl.containsKey(fob)) {
                User fobUser = accessControl.get(fob);
                fobUser.recordAccess(Calendar.getInstance().getTime());
                return true;
            }
        }
        return false;
    }

    /**
     * Produce a report about the data loaded and recorded by this unit
     *
     * @return a report as a string
     */
    public String produceReport() {
        String report = new String();

        Set<Fob> fobs = accessControl.keySet();
        for (Fob aFob : fobs) {
            User fobUser = accessControl.get(aFob);
            report = report.concat(aFob.getReportString());
            report = report.concat(fobUser.getReportString());
        }

        return report;
    }
}
