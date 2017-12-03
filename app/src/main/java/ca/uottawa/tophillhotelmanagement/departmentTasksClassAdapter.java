package ca.uottawa.tophillhotelmanagement;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Aleks048 on 12/3/2017.
 */

public class departmentTasksClassAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<Task> dataSource;

        public departmentTasksClassAdapter(Context context,ArrayList<Task> tasks){
            mContext=context;
            this.dataSource=tasks;
            mInflater=(android.view.LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount(){
            return this.dataSource.size();
        }

        @Override
        public Object getItem(int position){
            return this.dataSource.get(position);
        }

        @Override

        public long getItemId(int position){
            return position;
        }

        @Override

        public View getView(int position, View convertView, ViewGroup parent){
            View rowView = mInflater.inflate(R.layout.activity_department_task_row,parent,false);

            TextView nameTextView = (TextView) rowView.findViewById(R.id.department_task_List_Name);

            TextView detailTextView =
                    (TextView) rowView.findViewById(R.id.department_task_List_Description);

            final TextView countDownChronometer =
                    (TextView) rowView.findViewById(R.id.department_task_list_countDown);

            ImageView avatarImageView =
                    (ImageView) rowView.findViewById(R.id.department_list_task_Avatar);



        Task task = (Task)getItem(position);

        int taskNum = position+1;
        nameTextView.setText("Cleaning task #"+taskNum);

        detailTextView.setText(task.getTaskName());


        int rand = ThreadLocalRandom.current().nextInt(0, 500000);

        new CountDownTimer(rand, 1000) {
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished>=0){
                    Date temp = new Date();
                    temp.setTime(millisUntilFinished);
                    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                    countDownChronometer.setText(""+sdf.format(temp));}
                else{
                    countDownChronometer.setText("0");
                }
            }

            public void onFinish() {
            }
        }.start();

        avatarImageView.setImageResource(R.mipmap.departmenttaskimage);



            return rowView;
        }
    }

