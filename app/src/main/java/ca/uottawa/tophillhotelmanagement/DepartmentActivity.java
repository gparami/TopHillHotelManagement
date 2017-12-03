package ca.uottawa.tophillhotelmanagement;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_list_main_activity);
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

    }}
