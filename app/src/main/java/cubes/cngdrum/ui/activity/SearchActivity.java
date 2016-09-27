package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cubes.cngdrum.R;

/**
 * Created by cubesschool5 on 6/29/16.
 */
public class SearchActivity extends Activity {


    private EditText mEditTextName;

    private Spinner mSpinnerRegion;

    private Spinner mSpinnerFilter;

    private Button mButtonContinueSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);


        mButtonContinueSearch=(Button)findViewById(R.id.buttoncontinuesearch);
        mButtonContinueSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
