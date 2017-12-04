package ca.uottawa.tophillhotelmanagement;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class TaskHandlerActivity extends AppCompatActivity {

    Button assignEmployeeButton;
    Button updateTaskButton;
    Button deleteTaskButton;
    EditText taskNameET, taskDeadlineET;
    TextView taskAssignedToET;
    Calendar myCalendar;
    AlertDialog employeeSelectAlertDialog;
    ArrayList<Personnel> myStaff = null;
    Department myDepartment = null;
    CharSequence[] staffNames = null;
    Task currentTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_handler);
        setTitle("Edit Task");

        myStaff = ((Dataset) this.getApplication()).getStaffList();
        staffNames = EmployeeNameConversion(myStaff);
        currentTask = ((Dataset) this.getApplication()).getCurrentTask();
        myDepartment = ((Dataset) this.getApplication()).getCurrentDepartment();

        //Data Containers
        taskNameET = (EditText) findViewById(R.id.taskName);
        taskDeadlineET = (EditText) findViewById(R.id.taskDeadline);
        taskAssignedToET = (TextView) findViewById(R.id.taskAssignedTo);

        //Updating data containers with current task
        myCalendar = currentTask.getCalendarDueDate();
        taskNameET.setText(currentTask.getTaskName());
        taskDeadlineET.setText(getFormatedDate(currentTask.getCalendarDueDate()));
        if (currentTask.isAssigned()) { taskAssignedToET.setText(currentTask.getAssignedTo().getName()); }

        //Assign Employees Button
        assignEmployeeButton = (Button)findViewById(R.id.assignEmployeeButton);
        updateTaskButton = (Button) findViewById(R.id.updateTaskButton);
        deleteTaskButton = (Button) findViewById(R.id.deleteTaskButton);

        updateTaskButton.setClickable(false);
        updateTaskButton.setLongClickable(false);
        updateTaskButton.setBackground(getDrawable(R.drawable.grey_buttonstyle));

        assignEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonGroup() ;
            }
        });

        deleteTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteTaskConfirmationAlertDialog();
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                enableUpdateButton();
            }

        };

        taskDeadlineET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(TaskHandlerActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        taskNameET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableUpdateButton();
            }
        });

        updateTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTask.setTaskName(taskNameET.getText().toString());
                currentTask.setDueDate(myCalendar.getTime());
                Toast.makeText(TaskHandlerActivity.this, "Task Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void CreateAlertDialogWithRadioButtonGroup(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(TaskHandlerActivity.this);
        builder.setTitle("Select an Employee to Assign");
        builder.setSingleChoiceItems(staffNames, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {
                String assignedName = updateTaskAssignment(item);
                if (Objects.equals(assignedName, "unassigned.")) {
                    Toast.makeText(TaskHandlerActivity.this, "Set to " + assignedName, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(TaskHandlerActivity.this, "Assigned to " + assignedName, Toast.LENGTH_LONG).show();
                }
                employeeSelectAlertDialog.dismiss();
            }
        });
        employeeSelectAlertDialog = builder.create();
        employeeSelectAlertDialog.show();

    }

    public void DeleteTaskConfirmationAlertDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Please Confirm")
                .setMessage("Do you really want to delete this task?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        boolean deleteConfirmation = DeleteTask(currentTask);
                        if (deleteConfirmation) {
                            Toast.makeText(TaskHandlerActivity.this, "Task Deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(TaskHandlerActivity.this, "Delete Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }



    /**
     * Returns a list of employee names in an Char Sequence
     * @param myStaff list of personnel objects to extract names from
     * @return
     */
    public CharSequence[] EmployeeNameConversion(ArrayList<Personnel> myStaff) {

        CharSequence[] staffNames = new CharSequence[myStaff.size()+1];
        staffNames[0] = "Unassign";
        for (int i =1; i<myStaff.size(); i++) { staffNames[i] = myStaff.get(i).getName(); }
        return staffNames;
    }

    public String updateTaskAssignment(int itemNumber) {
        if (itemNumber == 0 ) {
            currentTask.unassign();
            taskAssignedToET.setText("Unassigned");
            return "unassigned.";
        } else {
            currentTask.setAssignedTo(myStaff.get(itemNumber));
            currentTask.setAssigned(true);
            taskAssignedToET.setText(currentTask.getAssignedTo().getName());
            return myStaff.get(itemNumber).getName();
        }
    }

    public String getFormatedDate(Calendar calDueDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calDueDate.getTime());
    }

    public boolean DeleteTask(Task T) {
        int index = findTaskInDepartmentTasks(T);
        if (index == -1 ) {
            return false;
        } else {
            myDepartment.getTasks().remove(index);
            ((Dataset) this.getApplication()).setCurrentDepartment(myDepartment);
            return true;
        }
    }

    public int findTaskInDepartmentTasks(Task currentTask) {
        int index = -1;
        for(Task T:myDepartment.getTasks()) {
            if (T == currentTask) {
                index = myDepartment.getTasks().indexOf(T);
            }
        }
        return index;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
        taskDeadlineET.setText(sdf.format(myCalendar.getTime()));
    }

    private void enableUpdateButton() {
        updateTaskButton.setClickable(true);
        updateTaskButton.setBackground(getDrawable(R.drawable.buttonstyle));
    }

}
