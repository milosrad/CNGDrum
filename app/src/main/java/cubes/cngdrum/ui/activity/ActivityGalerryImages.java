package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Gallery;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cubes.cngdrum.R;
import cubes.cngdrum.data.model.DataItem;
import cubes.cngdrum.ui.adapter.GalerryImagesAdapter;

/**
 * Created by cubesschool5 on 7/1/16.
 */
public class ActivityGalerryImages extends Activity {

    private Gallery mGalerry;

  //  private MyGallery mGalerry;

    private TextView mImagesCounter;

    private DataItem mDataItem;

    private int numimages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery_images);

        initComponents();


        int imagenum= getIntent().getIntExtra("position",0);
       int numimages= getIntent().getIntExtra("numofimages",0);

        mDataItem= (DataItem) getIntent().getExtras().get("object");


        mImagesCounter.setText(""+imagenum +"/"+ numimages);
        mImagesCounter.setTextColor(Color.BLACK);

    //    GalerryImagesAdapter mImagesAdapter= new GalerryImagesAdapter(ActivityGalerryImages.this,R.layout.activity_galery_images,mDataItem);
        GalerryImagesAdapter mImagesAdapter= new GalerryImagesAdapter(this);
        mGalerry.setAdapter(mImagesAdapter);

    //    mGalerry.setSpacing(1);

        AnimationSet set = new AnimationSet(true);
        Animation animation_fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animation_fadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        set.addAnimation(animation_fadeout);
        set.addAnimation(animation_fadein);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);

        mGalerry.setLayoutAnimation(controller);

         scrollGalery();

    //    scrollGallery1();










    }


    private void initComponents()
    {

        mGalerry=(Gallery)findViewById(R.id.galeryimages);

     //   mGalerry=(MyGallery)findViewById(R.id.galeryimages);



        mImagesCounter=(TextView)findViewById(R.id.imagecounter);
    }

    private void scrollGalery(){

        final int numimages1= getIntent().getIntExtra("numofimages",0);
        mGalerry.postDelayed(new Runnable() {


            @Override
            public void run() {


                if (mGalerry.getSelectedItemPosition() == mGalerry.getCount() - 1) {

                    mGalerry.setSelection(0);
                    mImagesCounter.setText(mGalerry.getSelectedItemPosition()+1 +"/"+ numimages1);
                    scrollGalery();
                    return;

                } else {
                    mGalerry.setSelection(mGalerry.getSelectedItemPosition() + 1);
                    mImagesCounter.setText(mGalerry.getSelectedItemPosition()+1 +"/"+ numimages1);
                    scrollGalery();

                    onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
                }


            }
        }, 2000);


    }

    private void scrollGallery1(){
        final int numimages1= getIntent().getIntExtra("numofimages",0);
        mGalerry.postDelayed(new Runnable() {


            @Override
            public void run() {

                int position= getIntent().getIntExtra("position",0);
                if (position == mGalerry.getCount() - 1) {

                    mGalerry.setSelection(0);
                    mImagesCounter.setText(position+1 +"/"+ numimages1);
                    scrollGallery1();
                    return;

                } else {
                    mGalerry.setSelection(position + 1);
                    mImagesCounter.setText(position+1 +"/"+ numimages1);
                    scrollGallery1();

                    onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
                }


            }
        }, 2000);




    }


}
