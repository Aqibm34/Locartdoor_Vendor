package aquib.mohd.locartdoorvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(splash_screen.this);


        ImageButton next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (account != null&& !account.isExpired()){
                    startActivity(new Intent(splash_screen.this, Home_page.class));
                }
                else{
                    startActivity(new Intent(splash_screen.this,MainActivity.class));
                    finish();
                }
            }
        });

    }
}
