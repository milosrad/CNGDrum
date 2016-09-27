package cubes.cngdrum.ui.fragment;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cubes.cngdrum.R;
import cubes.cngdrum.data.container.DataContainer;
import cubes.cngdrum.ui.activity.IconText;
import cubes.cngdrum.ui.adapter.SpinnerAdapter;

/**
 * Created by cubesschool5 on 6/29/16.
 */
public class SearchFragment extends DialogFragment {

    private View mRootView;

    private EditText mEditTextName;

    private Spinner mSpinnerRegion;

    private Spinner mSpinnerFilter;

    private Button mButtonContinueSearch;

    private IconText mDropDownRegion;

    private IconText mDropDownFilter;

    private OnSearchCompleteInterface mOnSearchCompleteInterface;

    public interface  OnSearchCompleteInterface{


        void onComplete(String name,String region,String tag);

    }



    public SearchFragment() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents();
        addListeners();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView=inflater.inflate(R.layout.fragment_search,container,false);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return mRootView;




    }



    private void initComponents(){


        mEditTextName=(EditText) mRootView.findViewById(R.id.edittextname);
        mButtonContinueSearch=(Button)mRootView.findViewById(R.id.buttoncontinuesearch);

        mDropDownFilter=(IconText)mRootView.findViewById(R.id.iconDropDownFilter);
        mDropDownRegion=(IconText)mRootView.findViewById(R.id.iconDropDownRegion);

        mSpinnerRegion=(Spinner) mRootView.findViewById(R.id.spinnerregion);
        mSpinnerFilter=(Spinner) mRootView.findViewById(R.id.spinnertags);

        mSpinnerRegion.setAdapter(new SpinnerAdapter(getActivity().getApplicationContext(),R.layout.list_item_spinner, DataContainer.regionList));
        mSpinnerFilter.setAdapter(new SpinnerAdapter(getActivity().getApplicationContext(),R.layout.list_item_spinner,DataContainer.taglist));






    }

    private void addListeners(){

         mButtonContinueSearch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(mOnSearchCompleteInterface!=null){

                     mOnSearchCompleteInterface.onComplete(mEditTextName.getText().toString(),mSpinnerRegion.getSelectedItem().toString(),mSpinnerFilter.getSelectedItem().toString());

                 }

                 dismiss();
             }
         });

        mDropDownRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSpinnerRegion.performClick();
            }
        });

        mDropDownFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDropDownFilter.performClick();
            }
        });



    }

    public void setOnSearchCompleteInterface(OnSearchCompleteInterface onSearchCompleteInterface){

        this.mOnSearchCompleteInterface=onSearchCompleteInterface;

    }




}
