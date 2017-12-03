package ca.uottawa.tophillhotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        final departmentTasksClassAdapter adapter = new departmentTasksClassAdapter(this, tasks);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // MediaPlayer m = MediaPlayer.create(EmployeesActivity.this, customEmployeeAdapter.staff.get(i));
                Task task =(Task) adapter.getItem(position);
                Intent intent = new Intent(view.getContext(), TaskHandlerActivity.class);
                set_task(task);
                startActivity(intent);
            }
        });
    }

    private void set_task(Task task){
        ((Dataset)this.getApplication()).setCurrentTask(task);
    }
}

