package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public class Department {

    private Personnel manager;

    public String departmentName;
    public Personnel manager;
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

    public void addEmployee(Employee empl){
        int pos = 0;
        String name = empl.getName();

        while(pos<deptEmployees.size()){
            if (deptEmployees.get(pos).getName().compareTo(name)<0){
                pos++;
            } else {
                deptEmployees.add(pos,empl);
                break;
            }
        }
        if(pos==deptEmployees.size()){
            deptEmployees.add(empl);
        }
    }
}