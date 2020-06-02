package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aquib.mohd.locartdoorvendor.Adapters.CustomExpandableListAdapter;
import aquib.mohd.locartdoorvendor.Adapters.DontHaveAadharCardData;
import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kyc extends Fragment {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    MaterialBetterSpinner s1;
    LinearLayout l1;
    TextInputEditText number,name;
    String[] type={"Aadhar Card","PAN Card","Driving License"};

    public Kyc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_kyc, container, false);
        s1=v.findViewById(R.id.s1);
        l1=v.findViewById(R.id.l1);
        number=v.findViewById(R.id.number);
        name=v.findViewById(R.id.name);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,type);
        s1.setAdapter(adapter1);

        s1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        l1.setVisibility(View.VISIBLE);
                        number.setHint("Enter Aadhar Card number");
                        name.setHint("Enter your name(as on Aadhar CARD)");
                        break;
                    case 1:
                        l1.setVisibility(View.VISIBLE);
                        number.setHint("Enter PAN CARD number");
                        name.setHint("Enter your name(as on PAN CARD)");
                        break;
                    case 2:
                        l1.setVisibility(View.VISIBLE);
                        number.setHint("Enter Driving License number");
                        name.setHint("Enter your name(as on Driving License)");
                        break;

                }
            }
        });

        return v;
    }
}
