package ca.uottawa.tophillhotelmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_main);
        setTitle("Department tasks");


//        ArrayList<Task> tasks = null;
//        final ArrayAdapter taskAdapter = new TaskAdapter(this, tasks);
//        ListView departmentList = (ListView) findViewById(R.id.deapartment_list_view);
//        departmentList.setAdapter(taskAdapter);
//
//        departmentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                MediaPlayer m = MediaPlayer.create(FamilyActivity.this, familyAdaper.w.get(i).getsId());
////                m.start();
//            }
//        });


    }

}