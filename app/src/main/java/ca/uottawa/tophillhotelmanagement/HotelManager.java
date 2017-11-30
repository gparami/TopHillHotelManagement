package ca.uottawa.tophillhotelmanagement;

import java.util.ArrayList;

/**
 * Created by parami on 2017-11-29.
 */

public class HotelManager extends Personnel {

    ArrayList<Department> hotelDepartments;

    HotelManager(String _n, String _email, int _pic, Department d, ArrayList<Department> departments){
        super( _n, _email, _pic);
        hotelDepartments = departments;
    }
}
