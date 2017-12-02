package ca.uottawa.tophillhotelmanagement;

import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public class Employee extends Personnel {

    private Department myDepartment;

    public Department currentDepartment(){
        return myDepartment;
    }

    Employee(String _n, String _email, int _pic, Department d){
        super( _n, _email, _pic);
        myDepartment = d;
    }
}
