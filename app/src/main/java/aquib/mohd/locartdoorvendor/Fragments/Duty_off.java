package aquib.mohd.locartdoorvendor.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import aquib.mohd.locartdoorvendor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Duty_off extends Fragment {

    RelativeLayout card;
    TextView status;
    Switch aSwitch;
    LinearLayout shop;

    public Duty_off() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_duty_off, container, false);
        card=v.findViewById(R.id.cardlayout);
        status= v.findViewById(R.id.switchstatus);
        aSwitch=v.findViewById(R.id.switch1);
        shop=v.findViewById(R.id.shop);
        aSwitch.setChecked(true);
        card.setBackgroundColor(Color.GREEN);
        status.setTextColor(Color.GREEN);
        status.setText("ON");

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aSwitch.isChecked())
                {
                    card.setBackgroundColor(Color.GREEN);
                    status.setTextColor(Color.GREEN);
                    status.setText("ON");
                    shop.setBackgroundColor(Color.WHITE);
                }
                else {
                    EditText reason=new EditText(view.getContext());
                    AlertDialog.Builder alert=new AlertDialog.Builder(getActivity());
                    alert.setTitle("Do you want to off your Duty?");
                    alert.setMessage("Enter your reason");
                    alert.setCancelable(false);
                    alert.setView(reason);
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            aSwitch.setChecked(false);
                            card.setBackgroundColor(Color.RED);
                            status.setTextColor(Color.RED);
                            status.setText("OFF");
                            shop.setBackgroundColor(Color.GRAY);

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            aSwitch.setChecked(true);
                            shop.setBackgroundColor(Color.WHITE);

                        }
                    });
                    alert.create().show();

                }
            }
        });

        return v;
    }
}
