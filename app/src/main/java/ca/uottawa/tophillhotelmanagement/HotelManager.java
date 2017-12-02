package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by parami on 2017-11-29.
 */

public class HotelManager extends Personnel {

    public ArrayList<Department> hotelDepartments;
    public LinkedList<Personnel> staff ;

    HotelManager(String _n, String _email, int _pic, ArrayList<Department> departments){
        super( _n, _email, _pic);
        hotelDepartments = departments;
        staff = new LinkedList<>();

    }

    public void createEmployee(String name, String username, String department, String role){
        Iterator<Department> itr = hotelDepartments.iterator();
        Department employeeDepartment=null;
        Personnel newPersonnel = null;
        while(itr.hasNext()){
            Department currentDepartment = itr.next();
            if (currentDepartment.departmentName.equals(department)){
                employeeDepartment=currentDepartment;
                break;
            }
        }

        if(role.equals("Manager")){
            Manager newManager = new Manager(name,username,-1,employeeDepartment);
            employeeDepartment.manager=newManager;
            newPersonnel=newManager;
            //manager obj
            // depending on dept
        } else {
            Employee newEmployee = new Employee(name,username,-1,employeeDepartment);
            employeeDepartment.addEmployee(newEmployee);
            newPersonnel=newEmployee;
            //construct empl object
            // depending on dept
        }

        int pos = 0;
        while(pos<staff.size()){
            if (staff.get(pos).getName().compareTo(name)<0){
                pos++;
            } else {
                staff.add(pos,newPersonnel);
                break;
            }
        }
        if(pos==staff.size()){
            staff.add(newPersonnel);
        }
    }


}
