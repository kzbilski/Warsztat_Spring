package pl.coderslab.springDemoZbliski.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springDemoZbliski.exception.MovieServiceException;
import pl.coderslab.springDemoZbliski.model.Movie;
import pl.coderslab.springDemoZbliski.service.MovieService;

@RestController
public class MovieController {


    //service należy wstawić przez konstruktor a nie robić przez new bo spring zarządza budowaniem naszych obiektów i to wszystko połączy
    //za pomocą wstrzykiwania odnotacji
   private MovieService service;
    public MovieController(MovieService service) { //zadziała o ile service ma adnotację @Service
        this.service = service;
    }

    @PostMapping("api/v1/movies")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
        try{
            service.saveMovie(movie);
            return new ResponseEntity<>("film dodany poprawnie", HttpStatusCode.valueOf(200));
        }catch (MovieServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }
}
