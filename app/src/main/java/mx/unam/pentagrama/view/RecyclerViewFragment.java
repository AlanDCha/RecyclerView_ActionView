package mx.unam.pentagrama.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.pentagrama.R;
import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.model.Mascota;
import mx.unam.pentagrama.presenter.IRecyclerViewFragmentPresenter;
import mx.unam.pentagrama.presenter.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

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
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generateLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter;
        adapter = new MascotaAdapter(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void initAdapterRV(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}