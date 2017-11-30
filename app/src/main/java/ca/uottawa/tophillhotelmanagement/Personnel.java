package ca.uottawa.tophillhotelmanagement;

import java.util.Vector;

/**
 * Created by parami on 2017-11-29.
 */

public abstract class Personnel {

    String name;
    String email;
    //String password; not needed, password is saved on firevase
    //public Vector<Task> deptTasks = new Vector<>(); belongs to spesific manager should be created in managers class
    int picture;

    Personnel(String _n, String _email, int _pic){
        name = _n;
        email = _email;
        picture = _pic;
    }

    public String getEmail() {
        return email;
    }
    public int getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
}
