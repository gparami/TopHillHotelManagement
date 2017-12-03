package ca.uottawa.tophillhotelmanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        setTitle("My employees");
//        LinkedList<Personnel> employees = null;
//        final ArrayAdapter employeeAdapter = new PersonelAdapter(this, employees);
//        ListView employee_list = (ListView) findViewById(R.id.employee_list_view);
//        employee_list.setAdapter(employeeAdapter);

//        employee_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                MediaPlayer m = MediaPlayer.create(FamilyActivity.this, familyAdaper.w.get(i).getsId());
//                m.start();
//            }
//        });
    }
}
