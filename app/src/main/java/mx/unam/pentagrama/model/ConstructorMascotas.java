package mx.unam.pentagrama.model;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import mx.unam.pentagrama.R;
import mx.unam.pentagrama.database.AuxDatabase;
import mx.unam.pentagrama.database.ConstantDatabase;

public class ConstructorMascotas {

    private static final int LIKE = 1;
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
    
    public void giveLikeMascota(Mascota mascota){
        AuxDatabase db = new AuxDatabase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDatabase.TABLE_LIKES_CONTACT_ID_CONTACT, mascota.getId());
        contentValues.put(ConstantDatabase.TABLE_LIKES_CONTACT_NUMBER_LIKES, LIKE);
        db.insertLikeMascota(contentValues);
    }

    public int getLikeMascota(Mascota mascota){
        AuxDatabase db = new AuxDatabase(context);
        return db.getLikeMascota(mascota);
    }
}
