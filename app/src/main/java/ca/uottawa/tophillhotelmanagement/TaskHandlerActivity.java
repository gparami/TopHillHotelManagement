package ca.uottawa.tophillhotelmanagement;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskHandlerActivity extends AppCompatActivity {

    Button assignEmployeeButton;
    AlertDialog employeeSelectAlertDialog;
    ArrayList<Personnel> myStaff = ((Dataset) this.getApplication()).getStaffList();
    CharSequence[] staffNames = EmployeeNameConversion(myStaff);

    //Temporary Data
    Department myDepartment = ((Dataset) this.getApplication()).getCurrentDepartment();
    ArrayList<Task> myTasks = myDepartment.getTasks();
    Task currentTask = myTasks.get(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_handler);

        assignEmployeeButton = (Button)findViewById(R.id.assignEmployeeButton);

        assignEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateAlertDialogWithRadioButtonGroup() ;
            }

        });

    }

    public void CreateAlertDialogWithRadioButtonGroup(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(TaskHandlerActivity.this);

        builder.setTitle("Select an Employee to Assign");

        builder.setSingleChoiceItems(staffNames, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {

                switch(item)
                {
                    case 0:

                        Toast.makeText(TaskHandlerActivity.this, "First Item Clicked", Toast.LENGTH_LONG).show();
                        break;
                    case 1:

                        Toast.makeText(TaskHandlerActivity.this, "Second Item Clicked", Toast.LENGTH_LONG).show();
                        break;
                    case 2:

                        Toast.makeText(TaskHandlerActivity.this, "Third Item Clicked", Toast.LENGTH_LONG).show();
                        break;
                }
                employeeSelectAlertDialog.dismiss();
            }
        });
        employeeSelectAlertDialog = builder.create();
        employeeSelectAlertDialog.show();

    }

    /**
     * Returns a list of employee names in an Char Sequence
     * @param myStaff list of personnel objects to extract names from
     * @return
     */
    public CharSequence[] EmployeeNameConversion(ArrayList<Personnel> myStaff) {

        CharSequence[] staffNames = new CharSequence[myStaff.size()];
        for (int i =0; i<myStaff.size(); i++) { staffNames[i] = myStaff.get(i).getName(); }

        return staffNames;
    }
}
