package pl.coderslab.springDemoZbliski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springDemoZbliski.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
