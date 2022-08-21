package mx.unam.pentagrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.model.Mascota;

public class ListadoMascotas extends AppCompatActivity {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;
    public MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        mascotas = (ArrayList<Mascota>) intent.getSerializableExtra("mascotas");

        rvMascotas = findViewById(R.id.rvContacts2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        initAdapter();
    }

    public void initAdapter(){
        adapter = new MascotaAdapter(mascotas, this);
        rvMascotas.setAdapter(adapter);
    }

}