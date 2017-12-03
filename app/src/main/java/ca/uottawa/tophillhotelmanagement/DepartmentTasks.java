package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class DepartmentTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.department_tasks_list_view);
        Department department =LoadActivity.manager.myDepartment;
        ArrayList<Task> currentTasks = department.getTasks();



    }

}
