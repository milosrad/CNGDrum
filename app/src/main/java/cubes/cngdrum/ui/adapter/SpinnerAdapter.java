package cubes.cngdrum.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cubes.cngdrum.R;

/**
 * Created by cubesschool5 on 6/29/16.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mResource;

    private LayoutInflater mInflater;


    public SpinnerAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
        this.mInflater=LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent,false);
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position,convertView,parent,true);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent,boolean isDropDown){

        View row=convertView;
        Holder holder=null;

        if(row== null){

            if(isDropDown){

                row= mInflater.inflate(R.layout.list_item_spinner_dropdown,parent,false);

            }

            else {

                row=mInflater.inflate(mResource,parent,false);

            }

            holder= new Holder();

            holder.textView=(TextView)row.findViewById(R.id.text);

            row.setTag(holder);

        }

        else {

            holder=(Holder)row.getTag();

        }

        holder.textView.setText(getItem(position));

        return row;
    }

    private class Holder{

          public TextView textView;

    }
}
