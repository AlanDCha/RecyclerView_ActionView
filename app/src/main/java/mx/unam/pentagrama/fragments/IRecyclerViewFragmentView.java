package mx.unam.pentagrama.fragments;

import java.util.ArrayList;

import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.pojo.Mascota;

public interface IRecyclerViewFragmentView {

    void generateLinearLayoutVertical();
    MascotaAdapter createAdapter(ArrayList<Mascota> mascotas);
    void initAdapterRV(MascotaAdapter adapter);
}
