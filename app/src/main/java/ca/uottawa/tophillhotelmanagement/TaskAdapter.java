package ca.uottawa.tophillhotelmanagement;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.os.SystemClock;
//import android.widget.Chronometer; notneed now
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Why am I here on 2017-12-01.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    ArrayList<Task> tasks;
    Context c;

    public TaskAdapter(@NonNull Context context, /*@LayoutRes int resource,*/ ArrayList<Task> t) {
        super(context, R.layout.activity_task_row);//add this layout to constructor
        tasks = t;
        c = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vH = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.activity_task_row, parent, false);/// creating new view to return
            vH.taskName = (TextView) convertView.findViewById(R.id.department_task_List_Name);
            vH.description = (TextView) convertView.findViewById(R.id.department_task_List_Description);
            vH.countdown = (TextView) convertView.findViewById(R.id.department_task_list_countDown);
            vH.img = (ImageView) convertView.findViewById(R.id.department_list_task_Avatar);





            convertView.setTag(vH);
        } else {
            vH = (ViewHolder)convertView.getTag();
        }
        Task t = tasks.get(position);
        vH.taskName.setText(t.getTaskName());
        vH.description.setText("Incomplete");
        SimpleDateFormat sdf = new SimpleDateFormat("yy:mm:dd");
        vH.countdown.setText(""+sdf.format(t.getDueDate()));
        switch (t.getPriority()){
            case LOW :
                vH.img.setImageResource(R.drawable.low);
                break;

            case NORMAL:               vH.img.setImageResource(R.drawable.normal);
                break;

            default : vH.img.setImageResource(R.drawable.urg);

        }

        return convertView;
    }

    //class that is used in  resuicling
    static class ViewHolder {
        ImageView img;
        TextView taskName;
        TextView description;
        TextView countdown;
    }

}
