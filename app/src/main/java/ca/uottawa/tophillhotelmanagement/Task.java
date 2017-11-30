package ca.uottawa.tophillhotelmanagement;
import java.util.ArrayList;
import java.util.Vector;
/**
 * Created by parami on 2017-11-29.
 */

public abstract class Task {
    Personnel assignedTo;
    public enum Priority {
        LOW, NORMAL, HIGH
    }
    boolean isAssigned, isComplete;
    Priority priority;
    Task(Priority _p, Personnel _person){
        priority = _p;
        assignedTo = _person;
    }

}
