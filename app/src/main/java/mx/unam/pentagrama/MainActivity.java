package mx.unam.pentagrama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.adapters.PageAdapter;
import mx.unam.pentagrama.fragments.ProfileFragment;
import mx.unam.pentagrama.fragments.RecyclerViewFragment;
import mx.unam.pentagrama.pojo.Mascota;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMascotas;
    private Toolbar myActionBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionBar = findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        initMascotaList();
    }

    public void initMascotaList(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.gato1, "Pedro", "4"));
        mascotas.add(new Mascota(R.drawable.gato2, "Pablo", "5"));
        mascotas.add(new Mascota(R.drawable.gato3, "Alvin", "3"));
        mascotas.add(new Mascota(R.drawable.gato4, "Isaac", "2"));
        mascotas.add(new Mascota(R.drawable.gato5, "Alana", "4"));
        mascotas.add(new Mascota(R.drawable.gato6, "Santo", "5"));
        mascotas.add(new Mascota(R.drawable.gato7, "Louis", "3"));
        mascotas.add(new Mascota(R.drawable.gato8, "Georg", "2"));
        mascotas.add(new Mascota(R.drawable.gato9, "Gallo", "1"));
        mascotas.add(new Mascota(R.drawable.gato10, "Mario", "5"));
    }

    public void goSecondActivity(View view){

        mascotas.removeIf(mascota -> Integer.parseInt(mascota.getRating()) < 4);

        Intent intent = new Intent(this, ListadoMascotas.class);
        intent.putExtra("mascotas", mascotas);
        startActivity(intent);
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.pets_24);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContact:
                Intent intent = new Intent(this, AppForm.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent intent1 = new Intent(this, Biography.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
}