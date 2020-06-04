package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import aquib.mohd.locartdoorvendor.Fragments.Type.CurrentOrder;
import aquib.mohd.locartdoorvendor.Fragments.Type.PastOrder;
import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Paymentdetails extends Fragment {

    public Paymentdetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_paymentdetails, container, false);

        BottomNavigationView bottomNavigationView=v.findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,new Due()).commit();

        return v;
    }
    BottomNavigationView.OnNavigationItemSelectedListener listener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment=null;
            switch (item.getItemId())
            {
                case R.id.due:
                    selectedfragment=new Due();
                    break;

                case R.id.paid:
                    selectedfragment=new Paid();
                    break;

            }
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,selectedfragment).commit();
            return true;
        }
    };
}
