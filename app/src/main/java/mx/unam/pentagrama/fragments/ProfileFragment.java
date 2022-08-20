package mx.unam.pentagrama.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mx.unam.pentagrama.R;
import mx.unam.pentagrama.adapters.ProfileAdapter;
import mx.unam.pentagrama.pojo.Mascota;

public class ProfileFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvProfile;
    public ProfileAdapter adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        rvProfile = v.findViewById(R.id.rvProfile);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        rvProfile.setLayoutManager(glm);
        initMascotaList();
        initAdapter();
        return v;
    }

    private void initAdapter(){
        adapter = new ProfileAdapter(mascotas, getActivity());
        rvProfile.setAdapter(adapter);
    }

    public void initMascotaList(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.gato3, "4"));
        mascotas.add(new Mascota(R.drawable.gato3, "3"));
        mascotas.add(new Mascota(R.drawable.gato3, "5"));
        mascotas.add(new Mascota(R.drawable.gato3, "4"));
        mascotas.add(new Mascota(R.drawable.gato3, "5"));
        mascotas.add(new Mascota(R.drawable.gato3, "3"));
        mascotas.add(new Mascota(R.drawable.gato3, "5"));
        mascotas.add(new Mascota(R.drawable.gato3, "4"));
    }
}