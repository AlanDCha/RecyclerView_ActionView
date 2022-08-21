package mx.unam.pentagrama.presenter;

import android.content.Context;
import java.util.ArrayList;
import mx.unam.pentagrama.model.ConstructorMascotas;
import mx.unam.pentagrama.view.IRecyclerViewFragmentView;
import mx.unam.pentagrama.model.Mascota;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,
                                         Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        getContactDatabase();
    }

    @Override
    public void getContactDatabase() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.getData();
        showContactRV();
    }

    @Override
    public void showContactRV() {
        iRecyclerViewFragmentView.initAdapterRV(iRecyclerViewFragmentView.createAdapter(mascotas));
        iRecyclerViewFragmentView.generateLinearLayoutVertical();
    }
}
