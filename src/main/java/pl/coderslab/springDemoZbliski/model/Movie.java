package pl.coderslab.springDemoZbliski.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    @Column(name = "average_score")
    private double averageScore;

    public Movie(String title, String genre, double averageScore) {
        this.title = title;
        this.genre = genre;
        this.averageScore = averageScore;
    }

    //no args constr!
    public Movie() {
    }


    //getters!
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}
