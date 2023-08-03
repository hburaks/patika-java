import model.Category;
import model.Movie;
import model.Platform;
import model.Session;
import service.CategoryService;

import java.util.ArrayList;
import java.util.Scanner;

import static service.CategoryService.createDefaultCategories;

public class Main {
    public static void main(String[] args) {

        ArrayList<Category> categories = CategoryService.createDefaultCategories();




        ArrayList<Platform> platforms = new ArrayList<>();

        Platform netflix = new Platform("netflix");
        Platform bluTv = new Platform("Blu TV");
        Platform mubi = new Platform("MUBI");
        Platform exxen = new Platform("Exxen");
        Platform disneyPlus = new Platform("Disney+");

        platforms.add(netflix);
        platforms.add(bluTv);
        platforms.add(mubi);
        platforms.add(exxen);
        platforms.add(disneyPlus);

        ArrayList<Session> sessions = new ArrayList<>();

        Session firstSession = new Session("13.00");
        Session secondSession = new Session("16.00");
        Session thirdSession = new Session("19.00");
        Session fourthSession = new Session("22.00");

        sessions.add(firstSession);
        sessions.add(secondSession);
        sessions.add(thirdSession);
        sessions.add(fourthSession);

        ArrayList<Movie> movies = new ArrayList<>();

        Movie defaultOne = new Movie("Yeşil Yol", 142, (8.6), "Frank Darabont", netflix, categories.get(4), firstSession);
        Movie defaultTwo = new Movie("Esaretin Bedeli", 124, (9.3), "Frank Darabont", mubi, categories.get(4), secondSession);
        Movie defaultThird = new Movie("Matrix", 142, (8.7), "Wachowski", disneyPlus, categories.get(3), thirdSession);

        movies.add(defaultOne);
        movies.add(defaultTwo);
        movies.add(defaultThird);

        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("hBurak Sinemasına hoşgeldiniz." +
                    "\n1 - Kullanıcı" +
                    "\n2 - Yönetici" +
                    "\nKullanıcı mı yoksa yönetici mi olduğunuzu belirtiniz: ");

            int choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Kullanıcı olarak devam ediyorsunuz.");
                    giveMovies(movies, categories, platforms, sessions);
                    running = false;
                    break;
                case 2:
                    System.out.println("Yönetici olarak devam ediyorsunuz.");
                    getMovies(movies, categories, platforms, sessions);
                    running = false;
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void getMovies(ArrayList<Movie> movies, ArrayList<Category> categories, ArrayList<Platform> platforms, ArrayList<Session> sessions) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("1 - Film ekle" +
                    "\n2 - Filmler hakkında bilgi al" +
                    "\nNe yapmak istediğinizi belirtiniz: ");
            int choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Film ekleme kısmına yönlendiriliyorsunuz.");
                    getMovieInfo(movies, categories, platforms, sessions);
                    break;
                case 2:
                    System.out.println("Filmler hakkında bilgi alma kısmına yönlendiriliyorsunuz.");
                    giveMovies(movies, categories, platforms, sessions);
                    running = false;
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void getMovieInfo(ArrayList<Movie> movies, ArrayList<Category> categories, ArrayList<Platform> platforms, ArrayList<Session> sessions) {

        Scanner inp = new Scanner(System.in);
        System.out.print("Sisteme ekleyeceğiniz filmin ismini giriniz: ");
        String name = inp.nextLine();
        System.out.print("Sisteme ekleyeceğiniz filmin süresini giriniz: ");
        int duration = inp.nextInt();
        System.out.print("Sisteme ekleyeceğiniz filmin IMDB puanını giriniz: ");
        Double imdb = inp.nextDouble();
        while (imdb > 10 && imdb < 0) {
            System.out.print("Sisteme ekleyeceğiniz filmin IMDB puanı 0 ila 10 arası bir değer olmalı lütfen tekrar giriniz: ");
            imdb = inp.nextDouble();
        }
        System.out.print("Sisteme ekleyeceğiniz filmin yönetmenini giriniz: ");
        String director = inp.next();


        Movie movie = new Movie(name, duration, imdb, director);
        getMoviePlatforms(movie, platforms);
        getMovieCategories(movie, categories);
        getMovieSessions(movie, sessions);
        movies.add(movie);

    }

    public static void getMovieCategories(Movie movie, ArrayList<Category> categories) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("1 - Komedi" +
                    "\n2 - Korku" +
                    "\n3 - Macera" +
                    "\n4 - Bilim-Kurgu" +
                    "\n5 - Dram" +
                    "\n0 - Başka kategori eklemek istemiyorum." +
                    "\nSisteme ekleyeceğiniz filmin bulunduğu kategoriyi giriniz: ");
            int choice = inp.nextInt();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    movie.setCategory(categories.get(0));
                    System.out.println(movie.getName() + " filminin kategori listesine " + categories.get(0).getName() + " eklendi.");
                    break;
                case 2:
                    movie.setCategory(categories.get(1));
                    System.out.println(movie.getName() + " filminin kategori listesine " + categories.get(1).getName() + " eklendi.");
                    break;
                case 3:
                    movie.setCategory(categories.get(2));
                    System.out.println(movie.getName() + " filminin kategori listesine " + categories.get(2).getName() + " eklendi.");
                    break;
                case 4:
                    movie.setCategory(categories.get(3));
                    System.out.println(movie.getName() + " filminin kategori listesine " + categories.get(3).getName() + " eklendi.");
                    break;
                case 5:
                    movie.setCategory(categories.get(4));
                    System.out.println(movie.getName() + " filminin kategori listesine " + categories.get(4).getName() + " eklendi.");
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void getMoviePlatforms(Movie movie, ArrayList<Platform> platforms) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("1 - Netflix" +
                    "\n2 - BluTv" +
                    "\n3 - MUBI" +
                    "\n4 - Exxen" +
                    "\n5 - Disney+" +
                    "\n0 - Başka platform eklemek istemiyorum." +
                    "\nSisteme ekleyeceğiniz filmin bulunduğu platformu giriniz: ");
            int choice = inp.nextInt();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    movie.setPlatform(platforms.get(0));
                    System.out.println(movie.getName() + " filminin platform listesine " + platforms.get(0).getName() + " eklendi.");
                    break;
                case 2:
                    movie.setPlatform(platforms.get(1));
                    System.out.println(movie.getName() + " filminin platform listesine " + platforms.get(1).getName() + " eklendi.");
                    break;
                case 3:
                    movie.setPlatform(platforms.get(2));
                    System.out.println(movie.getName() + " filminin platform listesine " + platforms.get(2).getName() + " eklendi.");
                    break;
                case 4:
                    movie.setPlatform(platforms.get(3));
                    System.out.println(movie.getName() + " filminin platform listesine " + platforms.get(3).getName() + " eklendi.");
                    break;
                case 5:
                    movie.setPlatform(platforms.get(4));
                    System.out.println(movie.getName() + " filminin platform listesine " + platforms.get(4).getName() + " eklendi.");
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void getMovieSessions(Movie movie, ArrayList<Session> sessions) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("1 - Birinci Seans - " + sessions.get(0).getTime() +
                    "\n2 - İkinci Seans - " + sessions.get(1).getTime() +
                    "\n3 - Üçüncü Seans - " + sessions.get(2).getTime() +
                    "\n4 - Dördüncü Seans - " + sessions.get(3).getTime() +
                    "\n0 - Başka seans eklemek istemiyorum." +
                    "\nSisteme ekleyeceğiniz filmin gösterileceği seansı giriniz: ");
            int choice = inp.nextInt();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    movie.setSession(sessions.get(0));
                    System.out.println(movie.getName() + " filmi " + sessions.get(0).getTime() + " seansına eklendi.");
                    break;
                case 2:
                    movie.setSession(sessions.get(1));
                    System.out.println(movie.getName() + " filmi " + sessions.get(1).getTime() + " seansına eklendi.");
                    break;
                case 3:
                    movie.setSession(sessions.get(2));
                    System.out.println(movie.getName() + " filmi " + sessions.get(2).getTime() + " seansına eklendi.");
                    break;
                case 4:
                    movie.setSession(sessions.get(3));
                    System.out.println(movie.getName() + " filmi " + sessions.get(3).getTime() + " seansına eklendi.");
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void giveMovies(ArrayList<Movie> movies, ArrayList<Category> categories, ArrayList<Platform> platforms, ArrayList<Session> sessions) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("\n1 - Filmler" +
                    "\n2 - Kategoriler" +
                    "\n3 - Platformlar" +
                    "\n4 - Seanslar" +
                    "\n0 - Çıkış"+
                    "\nHangi listeye göre bilgi almak istersiniz? : ");

            int choice = inp.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Programdan çıkış yapılıyor.");
                    running = false;
                    break;
                case 1:
                    System.out.println("Tüm filmler listeleniyor.");
                    giveDetailedInfoMovie(movies);
                    break;
                case 2:
                    System.out.println("Tüm kategoriler listeleniyor.");
                    giveDetailedInfoCategory(categories, movies);
                    break;
                case 3:
                    System.out.println("Tüm platformlar listeleniyor.");
                    giveDetailedInfoPlatform(platforms, movies);
                    break;
                case 4:
                    System.out.println("Tüm seanslar listeleniyor.");
                    giveDetailedInfoSession(sessions, movies);
                    break;
                default:
                    System.out.println("Lütfen belirtilen seçeneklerden birini giriniz.");
                    break;
            }
        }
    }

    public static void giveDetailedInfoMovie(ArrayList<Movie> movies){
        System.out.println("Bu listede olan toplam film sayısı: " + movies.size());
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + 1 + " - Film Adı: " + movies.get(i).getName());
        }
        System.out.print("Detaylı bilgi almak istediğiniz filmi belirtiniz: ");
        int id = inp.nextInt() - 1;
        Movie movie =  movies.get(id);
        System.out.println(movie.toString());
    }

    public static void giveDetailedInfoCategory(ArrayList<Category> categories, ArrayList<Movie> movies) {
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + " - Kategori: " + categories.get(i).getName());
        }
        Scanner inp = new Scanner(System.in);
        System.out.println("Detaylı bilgi almak istediğiniz kategoriyi belirtiniz: ");
        int id = inp.nextInt() - 1;
        ArrayList<Movie> moviesInThisCategory = new ArrayList<Movie>();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.get(i).getCategory().size(); j++){
                if(movies.get(i).getCategory().get(j) == categories.get(id)){
                    moviesInThisCategory.add(movies.get(i));
                }
            }
        }
        System.out.println(categories.get(id).getName() + " kategorisi listeleniyor.");
        giveDetailedInfoMovie(moviesInThisCategory);
    }

    public static void giveDetailedInfoPlatform(ArrayList<Platform> platforms, ArrayList<Movie> movies) {
        for (int i = 0; i < platforms.size(); i++) {
            System.out.println(i + 1 + " - Platform: " + platforms.get(i).getName());
        }
        Scanner inp = new Scanner(System.in);
        System.out.println("Detaylı bilgi almak istediğiniz platformu belirtiniz: ");
        int id = inp.nextInt() - 1;
        ArrayList<Movie> moviesInThisPlatform = new ArrayList<Movie>();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.get(i).getCategory().size(); j++){
                if(movies.get(i).getPlatform().get(j) == platforms.get(id)){
                    moviesInThisPlatform.add(movies.get(i));
                }
            }
        }
        System.out.println(platforms.get(id).getName() + " platformundaki filmler listeleniyor.");
        giveDetailedInfoMovie(moviesInThisPlatform);
    }

    public static void giveDetailedInfoSession(ArrayList<Session> sessions, ArrayList<Movie> movies) {
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println(i + 1 + " - Seans: " + sessions.get(i).getTime());
        }
        Scanner inp = new Scanner(System.in);
        System.out.println("Detaylı bilgi almak istediğiniz seansı belirtiniz: ");
        int id = inp.nextInt() - 1;
        ArrayList<Movie> moviesInThisSeans = new ArrayList<Movie>();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.get(i).getCategory().size(); j++){
                if(movies.get(i).getSession().get(j) == sessions.get(id)){
                    moviesInThisSeans.add(movies.get(i));
                }
            }
        }
        System.out.println(sessions.get(id).getTime() + " seansındaki filmler listeleniyor.");
        giveDetailedInfoMovie(moviesInThisSeans);
    }
}
