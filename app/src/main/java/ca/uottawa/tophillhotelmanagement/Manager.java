package ca.uottawa.tophillhotelmanagement;

/**
 * Created by parami on 2017-11-29.
 */

public class Manager extends Personnel {

    Department myDepartment;

    Manager(String _n, String _email, int _pic, Department d){
    super( _n, _email, _pic);
    myDepartment = d;
    }

    public Department getMyDepartment() {
        return myDepartment;
    }

}
