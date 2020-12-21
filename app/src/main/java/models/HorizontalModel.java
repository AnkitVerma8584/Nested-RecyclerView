package models;

public class HorizontalModel {

    int image;
    String movieName, description;

    public HorizontalModel(){}

    public HorizontalModel(int image, String  movieName,String description) {
        this.image = image;
        this.movieName= movieName;
        this.description = description;
    }
    public int getImage() {
        return image;
    }

    public String getMovieName() {
        return movieName;
    }
    public String getDescription() {
        return description;
    }
}
