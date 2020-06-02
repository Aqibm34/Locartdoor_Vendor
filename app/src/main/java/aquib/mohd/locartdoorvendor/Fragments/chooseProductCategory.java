package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aquib.mohd.locartdoorvendor.R;

public class chooseProductCategory extends Fragment {

    public chooseProductCategory() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_choose_product_category, container, false);

        return v;
    }
}