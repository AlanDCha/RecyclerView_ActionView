package mx.unam.pentagrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.pojo.Mascota;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas = findViewById(R.id.rvContacts);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        initMascotaList();
        initAdapter();
    }

    public void initAdapter(){
        adapter = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adapter);
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

}