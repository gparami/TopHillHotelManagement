package ca.uottawa.tophillhotelmanagement;

import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public class Department {

    public Personnel manager;
    public Vector<Personnel> deptEmployees = new Vector<>();
    public Vector<Task> deptTasks = new Vector<>();

    public Task createTask(){
        return null;
    }

}