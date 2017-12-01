package ca.uottawa.tophillhotelmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.os.SystemClock;
//import android.widget.Chronometer; notneed now
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Why am I here on 2017-12-01.
 */

public class departmentAdapter extends ArrayAdapter<Department> {
    Department[] deps;
    Context c;

    public departmentAdapter(@NonNull Context context, /*@LayoutRes int resource,*/ Department[] d) {
        super(context, R.layout.activity_department_task);//add this layout to constructor
        deps = d;
        c = context;
    }

    @Override
    public int getCount() {return deps.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vH = null;//new ViewHolder();

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.anothercust, parent, false);/// creating new view to return
            vH.img = (ImageView) convertView.findViewById(R.id.deaprtmentTaskAvatar);
            vH.name = (TextView) convertView.findViewById(R.id.depatmentTaskName);
            vH.discrip = (TextView) convertView.findViewById(R.id.deaprtmentTaskDiscription);
            convertView.setTag(vH);

        } else {
            vH = (ViewHolder) convertView.getTag();
        }
        Department temp = deps[position];
        vH.name.setText("NAME");
        vH.discrip.setText("disc");
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
        TextView discrip;
        // Chronometer c;
    }

}
