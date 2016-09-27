package cubes.cngdrum.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import cubes.cngdrum.R;
import cubes.cngdrum.data.model.DataItem;
import cubes.cngdrum.ui.activity.ActivityGalerryImages;
import cubes.cngdrum.ui.activity.MyGallery;

/**
 * Created by cubesschool5 on 7/1/16.
 */
public class GalerryImagesAdapter extends BaseAdapter {

    private Context mContext;

 //   private DataItem mDataItem;

  //  private LayoutInflater mInflater;

 //   private int mResource;

  //  public ArrayList<String> mImages;  //mDataItem.galerryimages;

    public static int[] myImageIds = {R.drawable.gas_station,R.drawable.menu_logo,R.drawable.icon_cng,R.drawable.icon_map,R.drawable.servicesicon};


 /*   public GalerryImagesAdapter(Context context,int resource,DataItem dataItem){


        this.mContext=context;
        mDataItem=dataItem;
        mResource=resource;
        mInflater=LayoutInflater.from(context);
        mImages=mDataItem.galerryimages;


    } */

    public GalerryImagesAdapter(Context context) {
        this.mContext = context;
    }
    /*@Override
    public int getCount() {
        return mDataItem.galerryimages.size();
    } */

    @Override
    public int getCount() {
        return this.myImageIds.length;
    }

    /*@Override
    public Object getItem(int position) {
        return mDataItem.galerryimages.get(position);
    } */

    @Override
    public Object getItem(int position) {
        return position;
    }



   /* @Override
    public long getItemId(int position) {
        return position;
    } */

    @Override
    public long getItemId(int position) {
        return position;
    }





  /*  @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        Holder holder= null;

        if(row==null){

            row=mInflater.inflate(mResource,parent,false);

            holder = new Holder();

            holder.galerry=(Gallery)row.findViewById(R.id.galeryimages);



            holder.textView=(TextView)row.findViewById(R.id.imagecounter);


            row.setTag(holder);





        }
        else {

            holder=(Holder)row.getTag();
        }

        holder.galerry.setSelection(position);

        ImageView i = new ImageView(mContext);


        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.with(mContext).load(mImages.get(position)).into(i);


   //    Picasso.with(mContext).load(mImages.get(position)).into(mImages.get(position));






      /*  ImageView i = new ImageView(mContext);

        i.setImageResource(Integer.parseInt(mImages.get(position)));
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY); */




     //   return row;

  //  }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView iv = new ImageView(mContext);

        iv.setImageResource(myImageIds[position]);


        iv.setScaleType(ImageView.ScaleType.CENTER);
        //iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        //iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        //iv.setScaleType(ImageView.ScaleType.FIT_XY);
        //iv.setScaleType(ImageView.ScaleType.FIT_END);

        iv.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));

     //   iv.setLayoutParams(new MyGallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
        return iv;
    }






    private class Holder{

        public TextView textView;
        public Gallery  galerry;

    }
}
