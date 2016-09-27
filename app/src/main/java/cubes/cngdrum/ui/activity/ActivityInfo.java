package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import cubes.cngdrum.R;

/**
 * Created by User on 4.7.2016.
 */
public class ActivityInfo extends Activity {

    private IconText mItBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initComponents();
        addListeners();

    }

    private void initComponents(){

        mItBack=(IconText)findViewById(R.id.backinfo);
    }

    private void addListeners(){

        mItBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
