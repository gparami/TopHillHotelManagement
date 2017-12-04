package ca.uottawa.tophillhotelmanagement;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        setTitle("My employees");
        final ArrayList<Personnel> myStaff = ((Dataset) this.getApplication()).getStaffList();


        LinearLayout employerLayout = (LinearLayout) findViewById(R.id.employee_list_view);
        LayoutInflater inf = getLayoutInflater();

        View custom = (View) inf.inflate(R.layout.personel_tasks_list_view, employerLayout, false);
        employerLayout.addView(custom);
        ListView listmain = (ListView) findViewById(R.id.list_view_employee);
        final PersonelAdapter customEmployeeAdapter = new PersonelAdapter(EmployeesActivity.this, myStaff);
        listmain.setAdapter(customEmployeeAdapter);




        listmain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {

                setEmployee(myStaff.get(j));
                LayoutInflater layoutInflater = LayoutInflater.from(EmployeesActivity.this);
                View promptView = layoutInflater.inflate(R.layout.singleemployeeactivity, null);
                final AlertDialog personalDialog = new AlertDialog.Builder(EmployeesActivity.this).create();
                Button call = (Button) promptView.findViewById(R.id.call_employee_button);
                Button email = (Button) promptView.findViewById(R.id.send_email_emp_button);
                Personnel emp = getCurrentEmployee();
                personalDialog.setTitle(emp.getName());


                call.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:777-777-7777"));
                        startActivity(intent);

                    }
                });

                email.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Personnel emp = getCurrentEmployee();
                        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.setType("plain/text");
                        sendIntent.setData(Uri.parse(emp.getEmail()));
                        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                        sendIntent.putExtra(Intent.EXTRA_EMAIL, emp.getEmail());
                        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "I love you");
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)");
                        startActivity(sendIntent);

                    }
                });
                personalDialog.setView(promptView);
                personalDialog.show();

            }
        });

    }
  private void setEmployee(Personnel p){
       ((Dataset) this.getApplication()).setCurrentEmployee(p);
    }
    private Personnel getCurrentEmployee(){
        final Personnel emp = ((Dataset) this.getApplication()).getCurrentEmployee();
        return emp;
    }

}
