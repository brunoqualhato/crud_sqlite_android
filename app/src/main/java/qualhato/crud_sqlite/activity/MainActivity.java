package qualhato.crud_sqlite.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import qualhato.crud_sqlite.R;
import qualhato.crud_sqlite.fragments.Cadastro;
import qualhato.crud_sqlite.fragments.Listar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_cadastro:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout, new Cadastro())
                            .commit();

                    return true;
                case R.id.navigation_listar:


                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout, new Listar())
                            .commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_layout, new Cadastro())
                .commit();
    }

}
