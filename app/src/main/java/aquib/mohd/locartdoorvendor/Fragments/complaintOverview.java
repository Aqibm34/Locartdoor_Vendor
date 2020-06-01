package aquib.mohd.locartdoorvendor.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;



import aquib.mohd.locartdoorvendor.R;
public class complaintOverview extends Fragment {

    private SwitchCompat switchCompat;
    private TextView name,id,refid,orderid,date,issue,status;
    private Button submit;
    private String c_name,c_id,r_id,o_id,_date,_issue,_status;
    private Toolbar toolbar;
    public complaintOverview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_complaint_overview, container, false);

        switchCompat = v.findViewById(R.id.status_switch);
        name = v.findViewById(R.id.cust_name_co);
        id = v.findViewById(R.id.cust_id_co);
        orderid = v.findViewById(R.id.order_id_co);
        refid = v.findViewById(R.id.refid_co);
        date = v.findViewById(R.id.date_co);
        issue = v.findViewById(R.id.issue_co);
        status = v.findViewById(R.id.status_co);
        submit = v.findViewById(R.id.q_reply);

        Bundle b = getArguments();
        if(b!=null){
            c_name=b.getString("name");
            c_id=b.getString("id");
            r_id=b.getString("refid");
            o_id=b.getString("orderid");
            _date=b.getString("date");
            _issue=b.getString("issue");
            _status=b.getString("status");

            if(c_name!=null)
                name.setText(c_name);
            if(c_id!=null)
                id.setText(c_id);
            if(r_id!=null)
                refid.setText(r_id);
            if(o_id!=null)
                orderid.setText(o_id);
            if(_date!=null)
                date.setText(_date);
            if(_issue!=null)
                issue.setText(_issue);
            if(_status!=null)
                status.setText(_status);
        }

        assert _status != null;
        if(_status.equals("Active")) {
            switchCompat.setChecked(true);
            status.setTextColor(Color.RED);
        }

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    switchCompat.setChecked(true);
                    status.setText("Active");
                    status.setTextColor(Color.RED);
                }
                else{
                    switchCompat.setChecked(false);
                    status.setText("Closed");
                    status.setTextColor(Color.parseColor("#36d153"));
                }
            }
        });


        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Complaint detail");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        toolbar.setTitle("Customer complaints");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

    }

    @Override
    public void onResume() {
        super.onResume();
        toolbar.setTitle("Complaint detail");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);

    }

    @Override
    public void onStop() {
        super.onStop();
        toolbar.setTitle("Customer complaints");
        toolbar.findViewById(R.id.loc_toolbar_TV).setVisibility(View.GONE);
    }

}