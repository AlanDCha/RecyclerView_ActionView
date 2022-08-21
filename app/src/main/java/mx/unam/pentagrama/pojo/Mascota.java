package mx.unam.pentagrama.pojo;


import java.io.Serializable;

public class Mascota implements Serializable {

    private int photo;
    private String name;
    private String rating;
    private int numLikes;
    private int id;

    public Mascota(int photo, String name, String rating) {
        this.photo = photo;
        this.name = name;
        this.rating = rating;
    }

    public Mascota(int photo, String rating) {
        this.photo = photo;
        this.rating = rating;
    }

    public Mascota(int photo, String name, int numLikes) {
        this.photo = photo;
        this.name = name;
        this.numLikes = numLikes;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumLikes() { return numLikes; }

    public int getPhoto() { return photo; }

    public String getName() { return name; }

    public String getRating() { return rating; }

}