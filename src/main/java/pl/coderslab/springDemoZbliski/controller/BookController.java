package pl.coderslab.springDemoZbliski.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springDemoZbliski.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //GET czyli pobieranie danych z serwera

  /* @RequestMapping(path = "/books",method = RequestMethod.GET)
    public String getBook() {
       return "Alicja w krainie czarów";
    }*/


 /*   @RequestMapping(path = "/books",method = RequestMethod.GET)
    public Book getBook() {
        return new Book("Alicja w krainie czarów",150,1930);
    }*/

  /*  @RequestMapping(path = "/books", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook() {
        return new ResponseEntity<>(new Book("Alicja w krainie czarów", 150, 1930), HttpStatusCode.valueOf(201));
    }*/


    /*
     * 100-199 -> info
     * 200-299 -> success
     * 300-399 -> redirect
     * 400-499 -> bad request
     * 500-599 -> server error
     * */

    //GET,POST,PUT,PATCH -> wysyłanie danych na serwer
    //przesłanie maxYear przez parametr zapytania
    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks(int maxYear) {
        System.out.println(maxYear);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Alicja w krainie czarów", 150, 1930));
        books.add(new Book("Biblia", 400, 2020));

        List<Book> filtered = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() <= maxYear) {
                filtered.add(book);
            }
        }

        return new ResponseEntity<>(filtered, HttpStatusCode.valueOf(201));
    }

    //wysyłanie danych przez ciało zapytania
    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        System.out.println(book);
    }

    //przesłanie danych przez fragment ścieżki
    @RequestMapping(path = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book>getBook(@PathVariable int id) {

        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Alicja w krainie czarów", 150, 1930));
        books.add(new Book(2,"Biblia", 400, 2020));

        for (Book book : books) {
            if (book.getId() == id) {
                return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
            }
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }


}
