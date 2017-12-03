package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class DepartmentTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.department_list_main_activity);
        setTitle("Debarment tasks");
        //Department department = currentEmploye.currentDepartment();
       // ArrayList<Task> currentTasks = department.getAllTasks();

    }

}
