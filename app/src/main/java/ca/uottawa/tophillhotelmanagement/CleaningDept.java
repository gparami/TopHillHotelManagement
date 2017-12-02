package ca.uottawa.tophillhotelmanagement;

import java.util.LinkedList;

/**
 * Created by parami on 2017-11-29.
 */

public class CleaningDept extends Department {
    public LinkedList<Task> tasks = new LinkedList<>();
    public CleaningDept(String name,Personnel manager){
        super(name,manager);
    }
}
