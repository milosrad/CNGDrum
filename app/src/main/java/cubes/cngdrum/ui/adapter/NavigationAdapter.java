package cubes.cngdrum.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cubes.cngdrum.R;

/**
 * Created by User on 5.7.2016.
 */
public class NavigationAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mList;


    public NavigationAdapter(Context context) {
        this.mContext = context;
        this.mInflater=LayoutInflater.from(mContext);
        this.mList=mContext.getResources().getStringArray(R.array.menu_options);
    }

    @Override
    public int getCount() {
        return mList.length+1;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }


    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return 0;

        }
        else if(position==1 || position==6){
            return 1;
        }
        else if(position>6){
            return 2;
        }
        else{
            return 3;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;

        if(getItemViewType(position)==0){

            row=mInflater.inflate(R.layout.list_item_navigation_logo,parent,false);

        }

        else if(getItemViewType(position)==1){

            row= mInflater.inflate(R.layout.list_item_navigation_title,parent,false);

            TextView textView=(TextView)row.findViewById(R.id.textViewnavigationtitle);

            textView.setText(getItem(position-1).toString());
        }
        else if(getItemViewType(position)==2){

            row=mInflater.inflate(R.layout.list_item_navigation_text,parent,false);

            TextView textView=(TextView)row.findViewById(R.id.textViewnavigationtext);

            textView.setText(getItem(position-1).toString());


        }
        else{

            row=mInflater.inflate(R.layout.list_item_navigation_text_icon,parent,false);

            TextView textView=(TextView)row.findViewById(R.id.textViewnavigationtexticon);

            ImageView imageView=(ImageView)row.findViewById(R.id.imageViewnavigationtexticon);

            textView.setText(getItem(position-1).toString());

            switch (position){

                case 2: imageView.setImageResource(R.drawable.icon_cng);

                    break;

                case 3: imageView.setImageResource(R.drawable.icon_map);
                    break;

                case 4: imageView.setImageResource(R.drawable.icon_service);
                    break;

                case 5: imageView.setImageResource(R.drawable.icon_info);
                    break;

            }

        }

        return row;
    }
}
