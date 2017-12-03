package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Receptionist_CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist__create_task);

        final EditText task_name        = (EditText) findViewById(R.id.task_name);
        final EditText task_date    = (EditText) findViewById(R.id.task_date);
        final EditText task_priority     = (EditText) findViewById(R.id.task_priority);
        final Spinner task_department     = (Spinner) findViewById(R.id.task_department);
        final Spinner task_assign        = (Spinner) findViewById(R.id.task_assign);

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
                String date     = task_date.getText().toString();
                String priority   = task_priority.getText().toString();

                if (TextUtils.isEmpty(name)){
                    task_name.setError("Enter a Task Name");
                    task_name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(date)){
                    task_date.setError("Enter a Task Date");
                    task_date.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(priority)){
                    task_priority.setError("Enter a Task Priority");
                    task_priority.requestFocus();
                    return;
                }
            }
        });
    }
}

