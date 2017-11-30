package ca.uottawa.tophillhotelmanagement;

import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public abstract class Personnel {

    String Name;
    String email;
    String password;

    public Vector<Task> deptTasks = new Vector<>();

}
