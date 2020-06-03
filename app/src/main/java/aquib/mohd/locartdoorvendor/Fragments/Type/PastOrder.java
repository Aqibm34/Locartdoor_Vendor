package aquib.mohd.locartdoorvendor.Fragments.Type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.Adapters.PastOrderAdapter;
import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastOrder extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> status,orderId,cname,location,time,date,items,price;

    public PastOrder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_past_order, container, false);

        recyclerView=v.findViewById(R.id.recyclerview1);
        status=new ArrayList<String>();
        orderId=new ArrayList<String>();
        cname=new ArrayList<String>();
        location=new ArrayList<String>();
        time=new ArrayList<String>();
        date=new ArrayList<String>();
        items=new ArrayList<String>();
        price=new ArrayList<String>();

        status.add("DELIVERED");
        status.add("CANCELLED");
        orderId.add("#901");
        orderId.add("#902");
        cname.add("Sayan Pal");
        cname.add("Aquib");
        location.add("Sitalapara,Shyamnagar,Barrackpore");
        location.add("FiderRoad,Shyamnagar,North 24 Pargans");
        time.add("12:40PM");
        time.add("08:40PM");
        date.add("28/05/2020");
        date.add("28/05/2020");
        items.add("2 plates Full Mutton Biriyani");
        items.add("4 plates Half Chicken Biriyani");
        price.add("Rs.420/-");
        price.add("Rs.400/-");

        PastOrderAdapter pastOrderAdapter=new PastOrderAdapter(getActivity(),status,orderId,cname,location,time,date,items,price);
        recyclerView.setAdapter(pastOrderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}
