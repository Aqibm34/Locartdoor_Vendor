package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aquib.mohd.locartdoorvendor.Adapters.Payment;
import aquib.mohd.locartdoorvendor.R;


public class Due extends Fragment {

    RecyclerView duelist;
    ArrayList<String> cname,caddress,orderId,time,date,items,price;
    ArrayList<Integer> cimage;
    public Due() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_due, container, false);
        duelist=v.findViewById(R.id.duelist);
        cname=new ArrayList<String>();
        caddress=new ArrayList<String>();
        orderId=new ArrayList<String>();
        time=new ArrayList<String>();
        date=new ArrayList<String>();
        items=new ArrayList<String>();
        price=new ArrayList<String>();
        cimage=new ArrayList<Integer>();

        cname.add("Sayan Pal");
        caddress.add("G.T Road");
        cname.add("Ayan Roy");
        caddress.add("Feader Road,Shyamnagar");
        orderId.add("101");
        orderId.add("102");
        time.add("8:40PM");
        date.add("12/05/2020");
        time.add("9:40PM");
        date.add("13/05/2020");
        items.add("2 plates Full Mutton Biriyani");
        items.add("4 plates Half Chicken Biriyani");
        price.add("Rs.420/-");
        price.add("Rs.400/-");
        cimage.add(R.drawable.profile);
        cimage.add(R.drawable.profile);

        Payment payment=new Payment(getActivity(),cname,caddress,orderId,time,date,items,price,cimage);
        duelist.setAdapter(payment);
        duelist.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}