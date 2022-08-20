package mx.unam.pentagrama.pojo;


import java.io.Serializable;

public class Mascota implements Serializable {

    private int photo;
    private String name;
    private String rating;

    public Mascota(int photo, String name, String rating) {
        this.photo = photo;
        this.name = name;
        this.rating = rating;
    }

    public Mascota(int photo, String rating) {
        this.photo = photo;
        this.rating = rating;
    }

    public int getPhoto() { return photo; }

    public String getName() { return name; }

    public String getRating() { return rating; }

}