package ca.uottawa.tophillhotelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final EditText profile_name        = (EditText) findViewById(R.id.profile_name);
        final EditText profile_username    = (EditText) findViewById(R.id.profile_username);
        final EditText profile_password     = (EditText) findViewById(R.id.profile_password);
        final Spinner profile_department     = (Spinner) findViewById(R.id.profile_department);
        final Spinner profile_role        = (Spinner) findViewById(R.id.profile_role);

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
        profile_department.setAdapter(adapter);
        profile_role.setAdapter(adapter1);

        Button submission = (Button) findViewById(R.id.profile_post);
        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name      = profile_name.getText().toString();
                String username     = profile_username.getText().toString();
                String password   = profile_password.getText().toString();

                if (TextUtils.isEmpty(name)){
                    profile_name.setError("Enter a Name");
                    profile_name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(username)){
                    profile_username.setError("Enter a Username");
                    profile_username.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    profile_password.setError("Enter a Password");
                    profile_password.requestFocus();
                    return;
                }
            }
        });
    }
}
