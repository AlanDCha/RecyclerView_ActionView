package mx.unam.pentagrama.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.pentagrama.ListadoMascotas;
import mx.unam.pentagrama.R;
import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.pojo.Mascota;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdapter adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RecyclerViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        rvMascotas = v.findViewById(R.id.rvContacts);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        initMascotaList();
        initAdapter();
        return v;
    }

    private void initAdapter(){
        adapter = new MascotaAdapter(mascotas, getActivity());
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
}