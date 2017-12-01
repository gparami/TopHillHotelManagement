package ca.uottawa.tophillhotelmanagement;
import java.util.ArrayList;
import java.util.Vector;
/**
 * Created by parami on 2017-11-29.
 */

public abstract class Task {
    Personnel assignedTo;
    String name;
    public enum Priority {
        LOW, NORMAL, HIGH
    }
    int ready =
    boolean isAssigned, isComplete;
    Priority priority;
    Task(String _name, Priority _p, Personnel _person){
        name = _name;
        priority = _p;
        assignedTo = _person;
    }

}
