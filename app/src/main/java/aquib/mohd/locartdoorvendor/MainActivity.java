package aquib.mohd.locartdoorvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import aquib.mohd.locartdoorvendor.Fragments.Login;
import aquib.mohd.locartdoorvendor.Fragments.Register;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageButton login_btn,signup_btn;
//    public static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.btn_login);
        signup_btn = findViewById(R.id.btn_signup);

        login_btn.setOnClickListener(this);
        signup_btn.setOnClickListener(this);
//        sp = getSharedPreferences("login",MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_login:
                loadFragment(new Login());
                break;
            case R.id.btn_signup:
                loadFragment(new Register());
                break;
        }
    }

    private void loadFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.add(R.id.login_reg_contauiner,fragment,"tag");
        transaction.addToBackStack("tag");
        transaction.commit();
    }

}
