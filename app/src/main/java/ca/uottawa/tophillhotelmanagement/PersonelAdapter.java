package ca.uottawa.tophillhotelmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

//import android.os.SystemClock;
//import android.widget.Chronometer; notneed now

/**
 * Created by Why am I here on 2017-12-01.
 */

public class PersonelAdapter extends ArrayAdapter<Personnel> {
    LinkedList<Personnel> staff;
    Context c;

    public PersonelAdapter(@NonNull Context context, /*@LayoutRes int resource,*/ LinkedList<Personnel> s) {
        super(context, R.layout.personel_tasks_list_view);//add this layout to constructor
        staff = s;
        c = context;
    }
    @Override
    public int getCount() {return staff.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vH = null;//new ViewHolder();

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.personel_tasks_list_view, parent, false);/// creating new view to return
            vH.img = (ImageView) convertView.findViewById(R.id.employee_photo);
            vH.name = (TextView) convertView.findViewById(R.id.employee_name);
            vH.email = (TextView) convertView.findViewById(R.id.email);
            convertView.setTag(vH);

        } else {
            vH = (ViewHolder) convertView.getTag();
        }
        Personnel temp = staff.get(position);
        vH.name.setText("NAME");
        vH.email.setText("email");
        vH.img.setImageResource(R.drawable.inprosses_task);
        //vH.img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        // vH.c.setBase(SystemClock.elapsedRealtime());
        //vH.c.start();
        return convertView;
    }

    //class that is used in  resuicling
    static class ViewHolder {
        ImageView img;
        TextView name;
        TextView email;
        // Chronometer c;
    }

}
