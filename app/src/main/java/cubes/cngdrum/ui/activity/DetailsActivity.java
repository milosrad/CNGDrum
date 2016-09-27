package cubes.cngdrum.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import cubes.cngdrum.R;
import cubes.cngdrum.data.model.DataItem;
import cubes.cngdrum.ui.adapter.GalerryImagesAdapter;

/**
 * Created by User on 28.6.2016.
 */
public class DetailsActivity extends Activity {

    private Gallery mGalerry;
   // private MyGallery mGalerry;
    private DataItem mDataItem;


    private ImageView mImageView;
    private TextView mLocation;
    private TextView mPhoneNumber;
    private TextView mWebPage;
    private IconText mItBack;

    private Handler handler;

    private boolean isGalleryClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initComponents();
        addListeners();

        AnimationSet set = new AnimationSet(true);
        Animation animation_fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animation_fadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        set.addAnimation(animation_fadeout);
        set.addAnimation(animation_fadein);


        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);

        mGalerry.setLayoutAnimation(controller);

     //   mGalerry.onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, new KeyEvent(0, 0));

        mGalerry.onFling(null, null, 100, 0);

        handler=new Handler();

        isGalleryClicked=false;



       scrollGalery();




    }


    private void initComponents() {

        mGalerry = (Gallery) findViewById(R.id.imageViewdetails);

    //    mGalerry=(MyGallery)findViewById(R.id.imageViewdetails);


        mGalerry.setSpacing(1);

        mDataItem = (DataItem) getIntent().getExtras().getSerializable("dataitem");

        if(mDataItem.isPay) {


            //   GalerryImagesAdapter mImagesAdapter = new GalerryImagesAdapter(DetailsActivity.this,R.layout.activity_galery_images, mDataItem);
            GalerryImagesAdapter mImagesAdapter = new GalerryImagesAdapter(this);
            mGalerry.setAdapter(mImagesAdapter);
        }
        else {mGalerry.setVisibility(View.GONE);}





    //        mImageView = (ImageView) findViewById(R.id.imageViewdetails);

        mLocation = (TextView) findViewById(R.id.locatiomapdetails);
        mPhoneNumber = (TextView) findViewById(R.id.phonenumberdetails);
        mWebPage = (TextView) findViewById(R.id.webdetails);
        mItBack=(IconText)findViewById(R.id.backdetails);

        PhoneCallListener phoneListener = new PhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager) this
                .getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

    }

    private void addListeners() {

        mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);
            }
        });

        mPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog =
                        new AlertDialog.Builder(DetailsActivity.this)
                                .setTitle("Poziv broja?")
                                .setMessage("Da li ste sigurni da zelite da pozovete ovaj broj?")
                                .setPositiveButton("Poziv", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //     Intent phoneIntent = new Intent(Intent.ACTION_CALL,Uri.parse(mPhoneNumber.getText().toString()));
                                        //      phoneIntent.setData(Uri.parse(mPhoneNumber.getText().toString().trim()));
                                        // Intent phoneIntent = new Intent(DetailsActivity.this,PhoneCallActivity.class);
                                        //  phoneIntent.putExtra("phonenumber",mPhoneNumber.getText().toString());

                                        //     startActivity(phoneIntent);
                                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mPhoneNumber.getText().toString()));
                                        if (ActivityCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            // TODO: Consider calling
                                            //    ActivityCompat#requestPermissions
                                            // here to request the missing permissions, and then overriding
                                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                            //                                          int[] grantResults)
                                            // to handle the case where the user grants the permission. See the documentation
                                            // for ActivityCompat#requestPermissions for more details.
                                            return;
                                        }
                                        startActivity(intent);


                                    }
                                })
                                .setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).show();


            }
        });

        mWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mGalerry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DetailsActivity.this, ActivityGalerryImages.class);
                intent.putExtra("position", position+1);
             //   int numofimages = mDataItem.galerryimages.size();
             //   intent.putExtra("numofimages", numofimages);
                intent.putExtra("numofimages",GalerryImagesAdapter.myImageIds.length);
                intent.putExtra("object", mDataItem);
                startActivity(intent);
            }
        });

        mItBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);
            }
        });
    }

    private void scrollGalery(){


            mGalerry.postDelayed(new Runnable() {


                @Override
                public void run() {


                    if (mGalerry.getSelectedItemPosition() == mGalerry.getCount() - 1) {

                        mGalerry.setSelection(0);
                        scrollGalery();
                        return;

                    } else {
                        mGalerry.setSelection(mGalerry.getSelectedItemPosition() + 1);
                        scrollGalery();
                        onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
                    }


                }
            }, 2000);


    }

    private void scrollGallery1(){

        for(int i =0;i<mGalerry.getCount();i++){

            if(mGalerry.getItemIdAtPosition(i)==mGalerry.getCount() - 1){
                mGalerry.setSelection(0);
            }

            mGalerry.setSelection((Integer) mGalerry.getItemAtPosition(i+1));
            onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
        }



    }


    private class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                    isPhoneCalling = false;
                }

            }
        }
    }
}
