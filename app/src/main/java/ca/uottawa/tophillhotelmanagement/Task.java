package ca.uottawa.tophillhotelmanagement;
import java.util.Vector;
/**
 * Created by parami on 2017-11-29.
 */

public abstract class Task {

    public enum Priority {
        LOW, NORMAL, HIGH
    }

    boolean isAssigned, isComplete;
    Vector<Personnel> assignedTo = new Vector<>();

}
