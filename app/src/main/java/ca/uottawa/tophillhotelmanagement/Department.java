package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;

/**
 * Created by parami on 2017-11-29.
 */

public class Department {
    public String departmentName;
    public Personnel manager;
    public ArrayList<Personnel> deptEmployees = new ArrayList<>();
    public ArrayList<Task> deptTasks = new ArrayList<>();

    public Department(String name, Personnel manager){
        this.departmentName=name;
        this.manager=manager;
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