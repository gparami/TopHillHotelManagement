package ca.uottawa.tophillhotelmanagement;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_form);

        final EditText employee_name        = (EditText) findViewById(R.id.employee_name);
        final EditText employee_username    = (EditText) findViewById(R.id.employee_username);
        final EditText employee_password     = (EditText) findViewById(R.id.employee_password);
        final Spinner employee_department     = (Spinner) findViewById(R.id.employee_department);
        final Spinner employee_role        = (Spinner) findViewById(R.id.employee_role);

        // Create first ArrayAdapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_array, android.R.layout.simple_spinner_item);
        // Create second ArrayAdapter
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        employee_department.setAdapter(adapter);
        employee_role.setAdapter(adapter1);

        Button submission = (Button) findViewById(R.id.post_employee);
        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name      = employee_name.getText().toString();
                String username     = employee_username.getText().toString();
                String password   = employee_password.getText().toString();

                if (TextUtils.isEmpty(name)){
                    employee_name.setError("Enter Employee Name");
                    employee_name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(username)){
                    employee_username.setError("Enter Employee Username");
                    employee_username.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    employee_password.setError("Enter Employee Password");
                    employee_password.requestFocus();
                    return;
                }
            }
        });
    }

}