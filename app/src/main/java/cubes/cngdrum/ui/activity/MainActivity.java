package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import cubes.cngdrum.R;
import cubes.cngdrum.ui.adapter.NavigationAdapter;

/**
 * Created by markodragonjic on 6/24/16.
 */
public class MainActivity extends Activity  {  // implements View.OnTouchListener,View.OnClickListener

    private ImageView mIvCng, mIvMap, mIvService, mIvInfo;
    private IconText mItMenu;
    private DrawerLayout mDlMenu;
    private ListView mLVNavigation;
    private NavigationAdapter mAdapter;

    private Animation animationButton;
    private Animation animationButtonfadeout;


    private static final int STATIONS=1;
    private static final int SERVICES=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        inicComponent();

        addListener();

     //   initialization();

    /*    mIvCng.setOnTouchListener(this);
        mIvInfo.setOnTouchListener(this);
        mIvMap.setOnTouchListener(this);
        mIvService.setOnTouchListener(this);

        mIvCng.setOnClickListener(this);
        mIvInfo.setOnClickListener(this);
        mIvMap.setOnClickListener(this);
        mIvService.setOnClickListener(this); */


        animationButton= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_button);
        animationButtonfadeout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
      //  animationButton.setFillEnabled(true);
      //  animationButton.setFillAfter(true);

    }

    private void addListener() {
        mIvService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           //     mIvService.startAnimation(animationButton);
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
            //    intent.putExtra("services",true);
                intent.putExtra("content", SERVICES);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);

            }
        });
        mIvMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    mIvMap.startAnimation(animationButton);
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);


            }
        });
        mIvCng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   mIvCng.startAnimation(animationButton);
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
            //    intent.putExtra("services",false);
                intent.putExtra("content",STATIONS);
                startActivity(intent);
           //     mIvCng.startAnimation(animationButton);
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);

            }
        });
        mIvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           //     mIvInfo.startAnimation(animationButton);
                Intent intent = new Intent(getApplicationContext(),ActivityInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);


            }
        });

        mItMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDlMenu.openDrawer(mLVNavigation);
            }
        });

        mLVNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //CNG
                    case 2:
                        Intent intentCNG= new Intent(getApplicationContext(),ListViewActivity.class);
                        intentCNG.putExtra("content",STATIONS);
                        startActivity(intentCNG);
                        mDlMenu.closeDrawer(mLVNavigation);
                        break;

                    //MAP
                    case 3:
                        Intent intentMAP= new Intent(getApplicationContext(),MapActivity.class);
                        startActivity(intentMAP);
                        mDlMenu.closeDrawer(mLVNavigation);
                        break;

                    //SERVICE
                    case 4:
                        Intent intentSERVICES= new Intent(getApplicationContext(),ListViewActivity.class);
                        intentSERVICES.putExtra("content",SERVICES);
                        startActivity(intentSERVICES);
                        mDlMenu.closeDrawer(mLVNavigation);
                        break;

                    //INFO
                    case 5:
                        Intent intentINFO= new Intent(getApplicationContext(),ActivityInfo.class);
                        startActivity(intentINFO);
                        mDlMenu.closeDrawer(mLVNavigation);
                        break;

                    // ABOUT US
                    case 7:
                        Intent intentABOUTUS= new Intent(getApplicationContext(),AboutUsActivity.class);
                        startActivity(intentABOUTUS);
                        mDlMenu.closeDrawer(mLVNavigation);
                        break;

                }
            }
        });

        mIvService.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mIvService.startAnimation(animationButton);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                mIvService.performClick();

                return false;
            }
        });

        mIvMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mIvMap.startAnimation(animationButton);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                mIvMap.performClick();
                return false;
            }
        });

        mIvInfo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mIvInfo.startAnimation(animationButton);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)

                mIvInfo.performClick();
                return false;
            }
        });

        mIvCng.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mIvCng.startAnimation(animationButton);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                mIvCng.performClick();
                return true;
              //  return false;


            }
        });
    }




    private void inicComponent() {
        mIvCng = (ImageView) findViewById(R.id.imageViewCNG);
        mIvInfo = (ImageView) findViewById(R.id.imageViewInfo);
        mIvMap = (ImageView) findViewById(R.id.imageViewMap);
        mIvService = (ImageView) findViewById(R.id.imageViewService);
        mItMenu=(IconText)findViewById(R.id.menu);
        mDlMenu=(DrawerLayout)findViewById(R.id.drawer_layout);
        mLVNavigation=(ListView)findViewById(R.id.listViewNavigation);


        mAdapter= new NavigationAdapter(getApplicationContext());
        mLVNavigation.setAdapter(mAdapter);



    }


   /* @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            switch (v.getId()) {

                case R.id.imageViewCNG:
                    mIvCng.startAnimation(animationButton);

                    //    Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                    //    intent.putExtra("content",STATIONS);
                    //    startActivity(intent);
                    break;

                case R.id.imageViewInfo:
                    mIvInfo.startAnimation(animationButton);

                    break;

                case R.id.imageViewMap:
                    mIvMap.startAnimation(animationButton);

                    break;

                case R.id.imageViewService:
                    mIvService.startAnimation(animationButton);

                    break;


            }
        }
        return true;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageViewCNG:

                //   mIvCng.startAnimation(animationButton);
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                //    intent.putExtra("services",false);
                intent.putExtra("content",STATIONS);
                startActivity(intent);
                //     mIvCng.startAnimation(animationButton);
                break;


            case R.id.imageViewInfo:

                //     mIvInfo.startAnimation(animationButton);
                Intent intent1 = new Intent(getApplicationContext(),ActivityInfo.class);
                startActivity(intent1);


            case R.id.imageViewMap:

                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                break;


            case R.id.imageViewService:

                //     mIvService.startAnimation(animationButton);
                Intent intent2 = new Intent(getApplicationContext(), ListViewActivity.class);
                //    intent.putExtra("services",true);
                intent2.putExtra("content", SERVICES);
                startActivity(intent2);

                break;

        }

    } */
}
