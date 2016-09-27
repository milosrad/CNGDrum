package cubes.cngdrum.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cubes.cngdrum.R;
import cubes.cngdrum.data.model.DataItem;

/**
 * Created by markodragonjic on 6/27/16.
 */
public class StationListAdapter extends ArrayAdapter<DataItem> {

    private Context mContext;
    private int mResourcePay,mResourceNotPay;
    private LayoutInflater mInflater;


    public StationListAdapter(Context context, int resourcePay,int resourceNotPay, List<DataItem> objects) {
        super(context, resourcePay, objects);
        this.mContext = context;
        this.mResourcePay = resourcePay;
        this.mResourceNotPay = resourceNotPay;
        this.mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemViewType(int position) {
        if(getItem(position).isPay){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        HolderClass holder = null;

        if(getItemViewType(position)==0){
            if(row==null){
                row = mInflater.inflate(mResourcePay,parent,false);
                holder = new HolderClass();

                holder.title = (TextView) row.findViewById(R.id.title);
                holder.address = (TextView) row.findViewById(R.id.address);
                holder.distance = (TextView) row.findViewById(R.id.distanceValue);
                holder.time = (TextView) row.findViewById(R.id.time);
                holder.phoneNumber = (TextView) row.findViewById(R.id.phoneNumber);

                holder.imageView = (ImageView) row.findViewById(R.id.imageView);

                row.setTag(mResourcePay,holder);
            }
            else{
                holder = (HolderClass) row.getTag(mResourcePay);
            }

            DataItem dataItem = getItem(position);

            Picasso.with(mContext).load(dataItem.image).into(holder.imageView);
            holder.title.setText(dataItem.title);
            holder.time.setText(dataItem.accessTime);
            holder.phoneNumber.setText(dataItem.phoneNumber);

            if(dataItem.accessTime.length()>20){
                holder.address.setText(dataItem.address.substring(0,19)+"...");
            }
            else {
                holder.address.setText(dataItem.address);
            }

            holder.distance.setText(dataItem.distance+" km");

        }
       else{
            if(row==null){
                row = mInflater.inflate(mResourceNotPay,parent,false);
                holder = new HolderClass();

                holder.title = (TextView) row.findViewById(R.id.title);
                holder.address = (TextView) row.findViewById(R.id.address);
                holder.distance = (TextView) row.findViewById(R.id.distanceValue);
                holder.phoneNumber = (TextView) row.findViewById(R.id.phoneNumber);

                row.setTag(mResourceNotPay,holder);
            }
            else{
                holder = (HolderClass) row.getTag(mResourceNotPay);
            }

            DataItem dataItem = getItem(position);

            holder.title.setText(dataItem.title);
            holder.phoneNumber.setText(dataItem.phoneNumber);
            holder.address.setText(dataItem.address);
            holder.distance.setText(dataItem.distance+" km");
        }

        return row;
    }

    private class HolderClass{
        private TextView title,distance,address,time,phoneNumber;
        private ImageView imageView;
    }
}
