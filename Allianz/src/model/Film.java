package model;
import java.util.*;

public class Film {
    private String name;
    private String duration;
    private double imdb;
    private String director;
    private List<String> platformList;
    private String[] categoryList;

    // constructor
    public Film(String name, String duration, double imdb) {
        this.name = name;
        this.duration = duration;
        this.imdb = imdb;
    }
    // getter setter metodları encapsulate etme işlemidir.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }
}
