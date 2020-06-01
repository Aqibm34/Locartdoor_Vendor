package aquib.mohd.locartdoorvendor.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }
    private TextView vendorname,shopname;
    private CardView orderCV,complaints_CV,query_CV,dutyoff_CV,kyc_CV;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        vendorname = v.findViewById(R.id.vendor_name_tv);
        shopname = v.findViewById(R.id.shop_name_tv);
        orderCV = v.findViewById(R.id.order_CV);
        complaints_CV = v.findViewById(R.id.complaints_CV);
        query_CV = v.findViewById(R.id.query_CV);
        dutyoff_CV = v.findViewById(R.id.duty_offCV);
        kyc_CV = v.findViewById(R.id.kyc_CV);

        orderCV.setOnClickListener(order_lis);
        complaints_CV.setOnClickListener(complaints_lis);
        query_CV.setOnClickListener(query_lis);
        dutyoff_CV.setOnClickListener(duty_lis);
        kyc_CV.setOnClickListener(kyc_lis);

        return v;
    }

    private View.OnClickListener order_lis =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new Orders());
        }
    };

    private View.OnClickListener kyc_lis =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new Kyc());
        }
    };

    private View.OnClickListener query_lis =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new query());
        }
    };

    private View.OnClickListener complaints_lis =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new Complaints());
        }
    };

    private View.OnClickListener duty_lis =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadFragment(new Duty_off());
        }
    };

    private void loadFragment(Fragment fragment){

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left);
        transaction.add(R.id.homepage_frame_container,fragment,"tag");
        transaction.addToBackStack("tag");
        transaction.commit();

    }


}
