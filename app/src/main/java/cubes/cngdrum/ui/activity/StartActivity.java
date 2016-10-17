package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

import cubes.cngdrum.R;
import cubes.cngdrum.data.container.DataContainer;
import cubes.cngdrum.data.model.DataItem;

public class StartActivity extends Activity {

    private Animation animationLogo;

    private ImageView mImageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_start_page);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    loadData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }).start();


        mImageLogo=(ImageView)findViewById(R.id.imageViewlogo);
        animationLogo= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.drawable_set);

    }

    private void loadData(){
        for(int i=0;i<30;i++){
            DataItem dataItem = new DataItem();
            dataItem.title = "Pumpa "+i;
            dataItem.address = "Bulevar Mihajla Pupina "+i;
            dataItem.distance = ""+(10*i);
            dataItem.phoneNumber = "123412411"+i;
            dataItem.accessTime = "0h - 24h";
            dataItem.isPay = i%2==0;
            dataItem.image = "https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg";

            dataItem.galerryimages=new ArrayList<>();

            dataItem.galerryimages.add("https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg");

            DataContainer.gasStationsList.add(dataItem);
        }

        for(int i=0;i<30;i++){
            DataItem dataItem = new DataItem();
            dataItem.title = "Servis "+i;
            dataItem.address = "Bulevar Mihajla Pupina "+i;
            dataItem.distance = ""+10*i;
            dataItem.phoneNumber = "123412411"+i;
            dataItem.accessTime = "0h - 24h";
            dataItem.isPay = i%2==0;
            dataItem.image = "http://www.novosti.rs/upload/images/2015//12/22n/z-AMSS.jpg";

            dataItem.galerryimages=new ArrayList<>();

            dataItem.galerryimages.add("https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg");

            DataContainer.servicesList.add(dataItem);
        }





        DataItem dataItem = new DataItem();
        dataItem.title = "Servis Kragujevac ";
        dataItem.address = "Bulevar Mihajla Pupina ";
        dataItem.distance = ""+1000;
        dataItem.phoneNumber = "123412411";
        dataItem.accessTime = "0h - 24h";
        dataItem.isPay = true;
        dataItem.image = "http://www.novosti.rs/upload/images/2015//12/22n/z-AMSS.jpg";
        dataItem.longitude="44.012040";
        dataItem.latitude="20.905456";
        dataItem.features="Caffe bar";


        DataContainer.servicesList.add(dataItem);


        DataItem dataItem1 = new DataItem();
        dataItem1.title = "Pumpa Uzice ";
        dataItem1.address = "Bulevar Mihajla Pupina ";
        dataItem1.distance = ""+1000;
        dataItem1.phoneNumber = "123412411";
        dataItem1.accessTime = "0h - 24h";
        dataItem1.isPay= false;
        dataItem1.longitude="43.855192";
        dataItem1.latitude="19.843797";
        dataItem1.image = "https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg";

        DataContainer.gasStationsList.add(dataItem1);

        DataItem dataItem2 = new DataItem();
        dataItem2.title = "Pumpa Cacak ";
        dataItem2.address = "Bulevar Mihajla Pupina ";
        dataItem2.distance = ""+10000;
        dataItem2.phoneNumber = "123412411";
        dataItem2.accessTime = "0h - 24h";
        dataItem2.isPay =true;
        dataItem2.longitude="43.891693";
        dataItem2.latitude="20.349941";
        dataItem2.image = "https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg";

        DataContainer.gasStationsList.add(dataItem2);

        DataItem dataItem3 = new DataItem();
        dataItem3.title = "Servis Skoplje ";
        dataItem3.address = "Bulevar Mihajla Pupina ";
        dataItem3.distance = ""+1000;
        dataItem3.phoneNumber = "123412411";
        dataItem3.accessTime = "0h - 24h";
        dataItem3.isPay = true;
        dataItem3.image = "http://www.novosti.rs/upload/images/2015//12/22n/z-AMSS.jpg";
        dataItem3.longitude="41.999069";
        dataItem3.latitude="21.425574";
        dataItem3.features="Caffe bar";

        DataContainer.servicesList.add(dataItem3);

        DataItem dataItem4 = new DataItem();
        dataItem4.title = "Pumpa Banja Luka ";
        dataItem4.address = "Bulevar Mihajla Pupina ";
        dataItem4.distance = ""+10000;
        dataItem4.phoneNumber = "123412411";
        dataItem4.accessTime = "0h - 24h";
        dataItem4.isPay =true;
        dataItem4.longitude="44.771991";
        dataItem4.latitude="17.191402";
        dataItem4.image = "https://www.superkartica.rs/Content/Images/Partners/nis-petrol-thumb-800.jpg";

        DataContainer.gasStationsList.add(dataItem4);

        DataItem dataItem5 = new DataItem();
        dataItem5.title = "Servis Cetinje ";
        dataItem5.address = "Bulevar Mihajla Pupina ";
        dataItem5.distance = ""+1000;
        dataItem5.phoneNumber = "123412411";
        dataItem5.accessTime = "0h - 24h";
        dataItem5.isPay = true;
        dataItem5.image = "http://www.novosti.rs/upload/images/2015//12/22n/z-AMSS.jpg";
        dataItem5.longitude="42.393564";
        dataItem5.latitude="18.910839";
        dataItem5.features="Caffe bar";

        DataContainer.servicesList.add(dataItem5);



        DataContainer.regionList.add("Srbija");
        DataContainer.regionList.add("Hrvatska");
        DataContainer.regionList.add("BiH");
        DataContainer.regionList.add("CrnaGora");
        DataContainer.regionList.add("Makedonija");
        DataContainer.regionList.add("Rumunija");
        DataContainer.regionList.add("Bugarska");
        DataContainer.regionList.add("Slovenija");
        DataContainer.regionList.add("Madjarska");
        DataContainer.regionList.add("Albanija");
        DataContainer.regionList.add("Grcka");



        DataContainer.taglist.add("Caffe bar");
        DataContainer.taglist.add("Market");
        DataContainer.taglist.add("WC");
        DataContainer.taglist.add("Parking");
        DataContainer.taglist.add("Terassa");
        DataContainer.taglist.add("Wifi");



        }


    @Override
    protected void onResume() {
        super.onResume();
        mImageLogo.startAnimation(animationLogo);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}




