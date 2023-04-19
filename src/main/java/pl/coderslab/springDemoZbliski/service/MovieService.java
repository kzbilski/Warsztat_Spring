package pl.coderslab.springDemoZbliski.service;

import org.springframework.stereotype.Service;
import pl.coderslab.springDemoZbliski.exception.MovieServiceException;
import pl.coderslab.springDemoZbliski.model.Movie;
import pl.coderslab.springDemoZbliski.repository.MovieRepository;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveMovie(Movie movie) {
        if (movie.getTitle().isBlank()) {//nawet jak białe znaki (spacja enter itp) to też uzna ze puste
            throw new MovieServiceException("Trzeba koniecznie uzupełnić tytuł!!");
        }
        movieRepository.save(movie);
    }
}
