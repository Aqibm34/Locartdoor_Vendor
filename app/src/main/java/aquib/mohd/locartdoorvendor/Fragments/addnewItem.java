package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import aquib.mohd.locartdoorvendor.R;

public class addnewItem extends Fragment {

    public addnewItem() {
        // Required empty public constructor
    }

    private TextView catTV;
    private String category;
    private EditText cat_name_ET,item_name_ET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_addnew_item, container, false);

        catTV = v.findViewById(R.id.cat_tv);

        Bundle bundle = getArguments();

        if (bundle!=null){
            category = bundle.getString("category");
            if (category!=null)
                catTV.setText(category+" Item");
        }
        return v;
    }
}