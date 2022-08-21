package mx.unam.pentagrama.database;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.unam.pentagrama.R;
import mx.unam.pentagrama.pojo.Mascota;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getData(){
        AuxDatabase db = new AuxDatabase(context);
        insertThreeMascotas(db);
        return db.getAllMascotas();
    }

    public void insertThreeMascotas(AuxDatabase db){
        String[] names = {"Anahi", "Itzel", "Aldo"};
        for (String name : names) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantDatabase.TABLE_CONTACTS_NAME, name);
            contentValues.put(ConstantDatabase.TABLE_CONTACTS_PHOTO, R.drawable.gato4);
            db.insertMascota(contentValues);
        }
    }
}
