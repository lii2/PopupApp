package lii2.github.com.popupapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lii2 on 8/11/2016.
 */
public class FourthFragment extends Fragment{
    // newInstance constructor for creating fragment with arguments
    public static FourthFragment newInstance() {
        FourthFragment fourthFragment = new FourthFragment();
        Bundle args = new Bundle();
        fourthFragment.setArguments(args);
        return fourthFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        return view;
    }
}
