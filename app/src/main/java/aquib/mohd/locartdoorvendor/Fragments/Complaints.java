package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.Adapters.complaintAdapter;
import aquib.mohd.locartdoorvendor.Adapters.complaintsData;
import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Complaints extends Fragment {

    public Complaints() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private ArrayList<complaintsData> data = new ArrayList<>();
    private complaintAdapter adapter;
    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_complaints, container, false);
        recyclerView = v.findViewById(R.id.compalints_RV);

        adapter = new complaintAdapter(getActivity(),data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Customer complaints");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);


        prepareData();

         return v;
    }

    private void prepareData() {

        complaintsData d1 = new complaintsData("https//img","Aquib","Id:- 12100","1000022","Order ID: 4201","1-06-2020",
                "Food quality is not good","Active");
        data.add(d1);

        d1 = new complaintsData("https//img","Malik","12300","Id:- 1000023","4202","1-06-2020",
                "Worst delivery ever","Closed");
        data.add(d1);

        d1 = new complaintsData("https//img","Pal","12400","Id:- 1000024","4203","1-06-2020",
                "Food was cold when deliverd","Active");
        data.add(d1);

        d1 = new complaintsData("https//img","Sayan","12500","Id:- 1000025","4204","1-06-2020",
                "Late delivery","Active");
        data.add(d1);

        d1 = new complaintsData("https//img","Sayan","12600","Id:- 1000026","4205","1-06-2020",
                "Less Item recieved","Active");
        data.add(d1);

        adapter.notifyDataSetChanged();
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
        toolbar.setTitle("Customer complaints");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

    }

    @Override
    public void onStop() {
        super.onStop();
        toolbar.setTitle("");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.VISIBLE);
    }

}
