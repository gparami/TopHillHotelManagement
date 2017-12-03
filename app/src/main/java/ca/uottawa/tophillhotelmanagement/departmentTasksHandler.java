package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class departmentTasksHandler extends AppCompatActivity {


    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_tasks_handler);

        mListView = (ListView) findViewById(R.id.department_tasks_list_view);


        Department myDepartment = ((Dataset) this.getApplication()).getCurrentDepartment();

        final ArrayList<Task> tasks = myDepartment.getTasks();

        departmentTasksClassAdapter adapter = new departmentTasksClassAdapter(this, tasks);

        mListView.setAdapter(adapter);
    }
}

//// set
//((Dataset) this.getApplication()).setHotelManager(hotelManager);
//        ((Dataset) this.getApplication()).setStaffList(staffList);
//        ((Dataset) this.getApplication()).setCurrentDepartment(currentDepartment);
//        ((Dataset) this.getApplication()).setManager(manager);
//// get
//        HotelManager myHotelManager =  ((Dataset) this.getApplication()).getHotelManager();
//        ArrayList<Personnel> myStaff = ((Dataset) this.getApplication()).getStaffList();
//        Department myDepartment = ((Dataset) this.getApplication()).getCurrentDepartment();
//        Personnel myManager = ((Dataset) this.getApplication()).getManager();