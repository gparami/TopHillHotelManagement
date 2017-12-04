package ca.uottawa.tophillhotelmanagement;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

//import android.os.SystemClock;
//import android.widget.Chronometer; notneed now

/**
 * Created by Why am I here on 2017-12-01.
 */

public class PersonelAdapter extends ArrayAdapter<Personnel> {
    ArrayList<Personnel> staff;
    Context c;

    public PersonelAdapter(@NonNull Context context, /*@LayoutRes int resource,*/ ArrayList<Personnel> s) {
        super(context, R.layout.personel_tasks_list_view);//add this layout to constructor
        staff = s;
        c = context;
    }

    @Override
    public int getCount() {
        return staff.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vH = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.personel_tasks_list_view, parent, false);/// creating new view to return
            vH.img = (ImageView) convertView.findViewById(R.id.employee_photo);
            vH.name = (TextView) convertView.findViewById(R.id.employee_name);
            vH.email = (TextView) convertView.findViewById(R.id.email);
            convertView.setTag(vH);
        } else {
            vH = (ViewHolder)convertView.getTag();
        }
        Personnel p = staff.get(position);
        vH.name.setText(p.getName());
        vH.email.setText(p.getEmail());
        if(p.picture == -1){
        vH.img.setImageResource(R.drawable.default_avatar);}
        else  vH.img.setImageResource(p.getPicture());
        vH.img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);



        return convertView;
    }

    //class that is used in  resuicling
    static class ViewHolder {
        ImageView img;
        TextView name;
        TextView email;
    }



}

