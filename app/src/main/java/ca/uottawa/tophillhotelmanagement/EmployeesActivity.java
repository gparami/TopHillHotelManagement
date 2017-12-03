package ca.uottawa.tophillhotelmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

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

                Intent i = new Intent(EmployeesActivity.this, SingleEmployeeActivity.class);
                setEmployee(myStaff.get(j));
                startActivity(i);
            }
        });

    }
  private void setEmployee(Personnel p){
       ((Dataset) this.getApplication()).setCurrentEmployee(p);
    }
}
