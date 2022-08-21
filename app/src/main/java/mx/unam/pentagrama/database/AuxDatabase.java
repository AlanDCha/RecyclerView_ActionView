package mx.unam.pentagrama.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import mx.unam.pentagrama.model.Mascota;

public class AuxDatabase extends SQLiteOpenHelper {

    private Context context;

    public AuxDatabase(@Nullable Context context) {
        super(context, ConstantDatabase.DATABASE_NAME, null, ConstantDatabase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTableMascota = "CREATE TABLE " +
                ConstantDatabase.TABLE_CONTACTS + " (" +
                ConstantDatabase.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDatabase.TABLE_CONTACTS_NAME  + " TEXT, " +
                ConstantDatabase.TABLE_CONTACTS_PHOTO + " INTEGER" +
                ")";

        String queryCreateTableMascotaLikes = "CREATE TABLE " +
                ConstantDatabase.TABLE_LIKES_CONTACT + "(" +
                ConstantDatabase.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDatabase.TABLE_LIKES_CONTACT_ID_CONTACT   + " INTEGER, " +
                ConstantDatabase.TABLE_LIKES_CONTACT_NUMBER_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantDatabase.TABLE_LIKES_CONTACT_ID + ") " +
                "REFERENCES " + ConstantDatabase.TABLE_CONTACTS + "(" +
                ConstantDatabase.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCreateTableMascota);
        db.execSQL(queryCreateTableMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDatabase.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDatabase.TABLE_LIKES_CONTACT);
    }

    public ArrayList<Mascota> getAllMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM  " + ConstantDatabase.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registers =  db.rawQuery(query, null);

        while (registers.moveToNext()) {
            Mascota mascotaCurrent = new Mascota();
            mascotaCurrent.setId(registers.getInt(0));
            mascotaCurrent.setName(registers.getString(1));
            mascotaCurrent.setPhoto(registers.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantDatabase.TABLE_LIKES_CONTACT_NUMBER_LIKES
                    + ")" + " AS likes" + " FROM " + ConstantDatabase.TABLE_LIKES_CONTACT +
                    " WHERE " + ConstantDatabase.TABLE_LIKES_CONTACT_ID_CONTACT + " = " +
                    mascotaCurrent.getId();

            Cursor registerLikes = db.rawQuery(queryLikes, null);
            if (registerLikes.moveToNext()) {
                mascotaCurrent.setNumLikes(registerLikes.getInt(0));
            } else {
                mascotaCurrent.setNumLikes(0);
            }
            mascotas.add(mascotaCurrent);
        }

        db.close();

        return  mascotas;
    }

    public void insertMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDatabase.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

    public void insertLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDatabase.TABLE_LIKES_CONTACT, null, contentValues);
        db.close();
    }

    public int getLikeMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantDatabase.TABLE_LIKES_CONTACT_NUMBER_LIKES + ")" +
                " FROM "  + ConstantDatabase.TABLE_LIKES_CONTACT +
                " WHERE " + ConstantDatabase.TABLE_LIKES_CONTACT_ID_CONTACT + " = " +
                mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registers = db.rawQuery(query, null);

        if (registers.moveToNext()) {
            likes = registers.getInt(0);
        }
        db.close();

        return likes;
    }

}
