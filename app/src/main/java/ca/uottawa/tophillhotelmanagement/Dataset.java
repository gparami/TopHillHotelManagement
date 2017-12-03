package ca.uottawa.tophillhotelmanagement;

import android.app.Application;

import java.util.ArrayList;

/**
 * @Author: parami
 * @Date: 2017-12-03
 * @Project: TopHillHotelManagement
 */
public class Dataset extends Application {

    private HotelManager hotelManager;
    private ArrayList<Personnel> staffList ;
    private Manager manager;
    private Department currentDepartment;

    public ArrayList<Personnel> getStaffList() { return staffList; }
    public HotelManager getHotelManager() { return hotelManager; }
    public Manager getManager() { return manager; }
    public Department getCurrentDepartment() { return currentDepartment; }

    public void setHotelManager(HotelManager hotelManager) { this.hotelManager = hotelManager; }
    public void setStaffList(ArrayList<Personnel> staffList) { this.staffList = staffList; }
    public void setManager(Manager manager) { this.manager = manager; }
    public void setCurrentDepartment(Department currentDepartment) { this.currentDepartment = currentDepartment; }

}
