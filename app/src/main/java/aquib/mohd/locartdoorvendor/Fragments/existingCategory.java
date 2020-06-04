package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import aquib.mohd.locartdoorvendor.R;
public class existingCategory extends Fragment {

    public existingCategory() {
        // Required empty public constructor
    }

    private String category;
    private TextView catTv;
    private Spinner catSpinner,itemSpinner;
    ArrayAdapter<String> arrayAdapter;
    private String[] food_cat = {"Choose Category...","Fast Food","Lunch","Dinner","Chaat","Other"};
    private String[] food_item = {"Choose Category...","Burger","Pizza","Hotdog","Other"};

    private String[] groc_cat = {"Choose Category...","Spices","pulses","Dinner","Chaat","Other"};

//    private String[] food_cat = {"Choose Category...","Fast Food","Lunch","Dinner","Chaat","Other"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_existing_category, container, false);

        catSpinner = v.findViewById(R.id.cat_spinner);
        itemSpinner = v.findViewById(R.id.item_spinner);
        catTv = v.findViewById(R.id.cattv);

        Bundle bundle = getArguments();

        if (bundle!=null){
            category = bundle.getString("category");
            if (category!=null)
                catTv.setText(category+" Item");
        }

        if (category.equals("Food")) {
             arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, food_cat);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
        if (category.equals("Groceries")) {
            arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, groc_cat);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, food_item);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        itemSpinner.setAdapter(itemAdapter);
        catSpinner.setAdapter(arrayAdapter);

        return v;
    }
}