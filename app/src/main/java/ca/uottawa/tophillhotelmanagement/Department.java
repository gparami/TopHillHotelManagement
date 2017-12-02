package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by parami on 2017-11-29.
 */

public class Department {

    private String departmentName;
    private Personnel manager;
    private ArrayList<Personnel> deptEmployees = new ArrayList<>();
    private ArrayList<Task> deptTasks = new ArrayList<>() ;

    public String getDepartmentName(){return departmentName;}
    public Manager getDepartmentManager(){return (Manager)manager;}

    public Task createTask(String taskToName, Priority priority, Date date){return new Task(taskToName,priority,date);}
    public void addTask(Task in){deptTasks.add(in);}
    public ArrayList<Task>getTasks(){return new ArrayList<Task>(deptTasks);}
    public Task removeTasks(Task toRemove){
        if (deptTasks.contains(toRemove)){return deptTasks.remove(deptTasks.indexOf(toRemove));}
        else{return null;}
    }
    public Department(){
    }
    public Department(String name, Personnel manager){
        this.departmentName=name;
        this.manager=manager;
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