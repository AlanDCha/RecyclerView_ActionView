package mx.unam.pentagrama.view;

import java.util.ArrayList;

import mx.unam.pentagrama.adapters.MascotaAdapter;
import mx.unam.pentagrama.model.Mascota;

public interface IRecyclerViewFragmentView {

    void generateLinearLayoutVertical();
    MascotaAdapter createAdapter(ArrayList<Mascota> mascotas);
    void initAdapterRV(MascotaAdapter adapter);
}
