package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public class Department {

    private Personnel manager;


    private ArrayList<Personnel> deptEmployees ;
    private ArrayList<Task> deptTasks;

    public Department(){
        deptEmployees = new ArrayList<>();
        deptTasks = new ArrayList<>();
    }

    public void addTask(Task toAdd){
        deptTasks.add(toAdd);
    }

    public ArrayList<Task> getAllTasks(){
        return new ArrayList<Task>(deptTasks);
    }


    public Task createTask(){
        return null;
    }

}