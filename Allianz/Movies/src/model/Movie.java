package model;

import java.util.ArrayList;

public class Movie {
    private String name;
    private int duration;
    private double imdb;
    private ArrayList<Session> sessions;
    private String director;
    private ArrayList<Platform> platforms;
    private ArrayList<Category> categories;


    // constructor


    public Movie(String name, int duration, double imdb, String director) {
        this.name = name;
        this.duration = duration;
        this.imdb = imdb;
        this.director = director;
        this.sessions = new ArrayList<>();
        this.platforms = new ArrayList<>();
        this.categories = new ArrayList<>();
    }
    public Movie(String name, int duration, double imdb, String director, Platform platform, Category category, Session session){
        this.name = name;
        this.duration = duration;
        this.imdb = imdb;
        this.director = director;
        this.sessions = new ArrayList<>();
        this.platforms = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.platforms.add(platform);
        this.categories.add(category);
        this.sessions.add(session);

    }

    // getter setter metodları encapsulate etme işlemidir.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public ArrayList<Session> getSession() {
        return sessions;
    }

    public void setSession(Session session) {
        this.sessions.add(session);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Platform> getPlatform() {
        return platforms;
    }

    public void setPlatform(Platform platform) {
        this.platforms.add(platform);
    }

    public ArrayList<Category> getCategory() {
        return categories;
    }

    public void setCategory(Category category) {
        this.categories.add(category);
    }

    @Override
    public String toString() {
        StringBuilder sessionTimes = new StringBuilder();
        for (Session session : sessions) {
            sessionTimes.append(session.getTime()).append(", ");
        }
        if (sessionTimes.length() > 0) {
            sessionTimes.delete(sessionTimes.length() - 2, sessionTimes.length());
        }

        StringBuilder platformList = new StringBuilder();
        for (Platform platform : platforms) {
            platformList.append(platform.getName()).append(", ");
        }
        if (platformList.length() > 0) {
            platformList.delete(platformList.length() - 2, platformList.length());
        }

        StringBuilder categoryList = new StringBuilder();
        for (Category category : categories) {
            categoryList.append(category.getName()).append(", ");
        }
        if (categoryList.length() > 0) {
            categoryList.delete(categoryList.length() - 2, categoryList.length());
        }

        return "Film detayları:" +
                "\nFilmin adı = " + name +
                "\nFilmin süresi = " + duration +
                "\nFilmin IMDB puanı = " + imdb +
                "\nFilmin yönetmeni = " + director +
                "\nFilmin gösterim saatleri = " + sessionTimes.toString() +
                "\nFilmin platform listesi = " + platformList.toString() +
                "\nFilmin kategori listesi = " + categoryList.toString();
    }

}
