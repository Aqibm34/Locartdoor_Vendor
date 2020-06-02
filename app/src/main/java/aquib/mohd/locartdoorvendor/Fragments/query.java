package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import aquib.mohd.locartdoorvendor.R;

public class query extends Fragment {

    public query() {
        // Required empty public constructor
    }

    private Spinner spinner;
    private EditText query_TV;
    private ImageButton attachnebt;
    private Button submit;
    Toolbar toolbar;

    private String[] cat_pr = {"Choose Category...","Account","Product","Subscription","Orders","Other"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_query, container, false);

        spinner = v.findViewById(R.id.cat_spinner);
        query_TV = v.findViewById(R.id.q_ET);
        attachnebt = v.findViewById(R.id.attach_btn);
        submit = v.findViewById(R.id.submit_query);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,cat_pr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0)
                Toast.makeText(getActivity(),cat_pr[i],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        attachnebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Attachment",Toast.LENGTH_LONG).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Raise Query");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        toolbar.setTitle("");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        toolbar.setTitle("Raise Query");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

    }

    @Override
    public void onStop() {
        super.onStop();
        toolbar.setTitle("");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.VISIBLE);
    }
}
