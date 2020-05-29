package aquib.mohd.locartdoorvendor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.android.gms.common.SignInButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {


    private AppCompatEditText phoneEt;
    private ImageButton btn_getOTP;
    private String countryCode, phone, code;
    private FrameLayout overlay;
    private ProgressBar progressBar;
    private SignInButton signInButton;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        phoneEt = v.findViewById(R.id.phoneET);
        btn_getOTP = v.findViewById(R.id.btn_getOtp);
        overlay = v.findViewById(R.id.progress_circular_overlay);
        progressBar = v.findViewById(R.id.progress_circular);
        signInButton = v.findViewById(R.id.google_btn);
        signInButton.setSize(SignInButton.SIZE_STANDARD);


        btn_getOTP.setOnClickListener(listener);

        return v;
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(), Home_page.class));
        }
    };
}