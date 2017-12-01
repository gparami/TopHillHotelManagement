package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;

/**
 * Created by parami on 2017-11-29.
 */

public class Manager extends Personnel {

    Department myDepartment;
    ArrayList<Task> myTasks;

    Manager(String _n, String _email, int _pic, Department d){
    super( _n, _email, _pic);
    myDepartment = d;
    myTasks = new ArrayList<>();
    }

    public Department getMyDepartment() {
        return myDepartment;
    }


}
