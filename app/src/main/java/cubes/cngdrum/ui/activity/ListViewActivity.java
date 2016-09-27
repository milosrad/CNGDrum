package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cubes.cngdrum.R;
import cubes.cngdrum.data.container.DataContainer;
import cubes.cngdrum.data.model.DataItem;
import cubes.cngdrum.ui.adapter.StationListAdapter;
import cubes.cngdrum.ui.fragment.SearchFragment;

/**
 * Created by markodragonjic on 6/27/16.
 */
public class ListViewActivity extends Activity implements SearchFragment.OnSearchCompleteInterface {



    private IconText mItBack,mItSearch,mItMap;
    private ListView mListView;
    private StationListAdapter mAdapter;
    private SearchFragment mSearchFragment;
    private int mSelectedList;

    private ArrayList<DataItem> mDataItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_page);


        
        inicComponent();
        addListener();

        AnimationSet set = new AnimationSet(true);
        Animation animation_fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animation_fadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        set.addAnimation(animation_fadeout);
        set.addAnimation(animation_fadein);


        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);

        mListView.setLayoutAnimation(controller);







    }

    private void addListener() {
        mItBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);
            }
        });

        mItMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);
            }
        });
        mItSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchFragment searchFragment= new SearchFragment();
                searchFragment.setOnSearchCompleteInterface(ListViewActivity.this);
                searchFragment.show(getFragmentManager(),"");




            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);

                intent.putExtra("dataitem",(DataItem)parent.getAdapter().getItem(position));

                intent.putExtra("positionInList",position);

                intent.putExtra("list",mSelectedList);

                startActivity(intent);

                overridePendingTransition(R.anim.anim_activity_close_translate,R.anim.activity_close_scale);

             //   DataItem item= mAdapter.getItem(position);

             //   intent.putExtra("dataitem",item);

              //  if(item.isPay){
              //      String image= item.image;

              //      intent.putExtra("image",image);

              //  }
                //String image= item.image;

               // intent.putExtra("image",image);




            }
        });


    }

    private void inicComponent() {
        mItBack = (IconText) findViewById(R.id.back);
        mItSearch = (IconText) findViewById(R.id.search);
        mItMap = (IconText) findViewById(R.id.map);

        mListView = (ListView) findViewById(R.id.listView);

        if(getIntent().getIntExtra("content",2)==2){                                                                               //   getIntent().getBooleanExtra("services",true)


            mSelectedList=2;
            mDataItemList=DataContainer.servicesList;
            mAdapter = new StationListAdapter(getApplicationContext(),
                    R.layout.list_item_station_pay,R.layout.list_item_station_not_pay, mDataItemList);

        }
        else if (getIntent().getIntExtra("content",1)==1) {
            mSelectedList=1;
            mDataItemList=DataContainer.gasStationsList;
            mAdapter = new StationListAdapter(getApplicationContext(),
                    R.layout.list_item_station_pay,R.layout.list_item_station_not_pay, mDataItemList);

        }


        mListView.setAdapter(mAdapter);
        mSearchFragment= new SearchFragment();
        mSearchFragment.setOnSearchCompleteInterface(this);

    }

    @Override
    public void onComplete(String name,String region,String tag) {

        if(mSelectedList==2){

            searchList(DataContainer.servicesList,name,region,tag);
        }

        else if (mSelectedList==1){
            searchList(DataContainer.gasStationsList,name,region,tag);
        }
        else {
            finish();
        }

    }

    private void searchList(ArrayList<DataItem> list,String name,String region,String tag){

        mDataItemList=new ArrayList<>();

        for(DataItem dataItem:list){

            if(dataItem.title.toLowerCase().contains(name.toLowerCase()) &&
                    dataItem.region.contains(region) &&
                    dataItem.tags.contains(tag)) {

                      mDataItemList.add(dataItem);

            }

        }

        mAdapter= new StationListAdapter(getApplicationContext(),R.layout.list_item_station_pay,R.layout.list_item_station_not_pay,mDataItemList);
        mListView.setAdapter(mAdapter);

    }



}
