package mx.unam.pentagrama.database;

public final class ConstantDatabase {

    public static final String DATABASE_NAME    = "mascotas";
    public static final int    DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS    = "mascota";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NAME  = "name";
    public static final String TABLE_CONTACTS_PHOTO = "photo";

    public static final String TABLE_LIKES_CONTACT = "mascota_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACT = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUMBER_LIKES = "number_likes";
}
