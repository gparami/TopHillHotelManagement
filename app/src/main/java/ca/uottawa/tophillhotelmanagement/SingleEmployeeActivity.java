package ca.uottawa.tophillhotelmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SingleEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleemployeeactivity);
        Personnel p = ((Dataset) this.getApplication()).getCurrentEmployee();
        setTitle(p.getName());


    }
}
