package nyc.c4q.jordansmith.a12_21_16_exam;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            FragmentManager fG = getSupportFragmentManager();
            FragmentTransaction transaction = fG.beginTransaction();
            transaction.replace(R.id.fragment_holder, new MainFragment());
            transaction.commit();
        }


    }
}
