package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class Receptionist_CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist__create_task);

        final EditText task_name = (EditText) findViewById(R.id.task_name);
        final EditText task_date = (EditText) findViewById(R.id.task_date);
        final EditText task_priority = (EditText) findViewById(R.id.task_priority);
        final Spinner task_department = (Spinner) findViewById(R.id.task_department);
        final Spinner task_assign = (Spinner) findViewById(R.id.task_assign);

        // Create first ArrayAdapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_array, android.R.layout.simple_spinner_item);
        // Create second ArrayAdapter
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.task_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        task_department.setAdapter(adapter);
        task_assign.setAdapter(adapter1);

        Button submission = (Button) findViewById(R.id.task_post);
        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name      = task_name.getText().toString();
                String dateTxt     = task_date.getText().toString();
                String priorityTxt = task_priority.getText().toString();
                String assignTo = task_assign.getSelectedItem().toString();

                if (TextUtils.isEmpty(name)){
                    task_name.setError("Enter a Task Name");
                    task_name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(dateTxt)){
                    task_date.setError("Enter a Task Date");
                    task_date.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(priorityTxt)){
                    task_priority.setError("Enter a Task Priority");
                    task_priority.requestFocus();
                    return;
                }
                Toast.makeText(Receptionist_CreateTask.this, "Task Created", Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }
    public Task createTaskObject(){

        final EditText task_name = (EditText) findViewById(R.id.task_name);
        final EditText task_date = (EditText) findViewById(R.id.task_date);
        final EditText task_priority = (EditText) findViewById(R.id.task_priority);
        final Spinner task_department = (Spinner) findViewById(R.id.task_department);
        final Spinner task_assign = (Spinner) findViewById(R.id.task_assign);

        String name      = task_name.getText().toString();
        String dateTxt     = task_date.getText().toString();
        String priorityTxt = task_priority.getText().toString();
        String assignTo = task_assign.getSelectedItem().toString();

        // String format "2015-08-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
            date = sdf.parse(dateTxt);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        Priority priority = null;
        if (priorityTxt == "LOW") {
            priority = Priority.LOW;
        }
        else if (priorityTxt == "NORMAL"){
            priority = Priority.NORMAL;
        }
        else if (priorityTxt == "HIGH"){
            priority = Priority.HIGH;
        }

        HotelManager myHotelManager = ((Dataset) this.getApplication()).getHotelManager();
        ArrayList<Personnel> EmployeeList = myHotelManager.staff;
        Personnel assignedPersonnel = null;

        for(Personnel obj : EmployeeList){
            if(obj.getName() == assignTo){
                assignedPersonnel = obj;
                break;
            }
        }
        Task taskobject;
        if(assignTo == null){
            taskobject = new Task(name, priority, date);
        }
        else{
            taskobject = new Task(name, priority, date, assignedPersonnel);
        }
        return taskobject;
    }

}

