package pl.coderslab.springDemoZbliski.exception;

public class MovieServiceException extends RuntimeException {
    public MovieServiceException(String message) {
        super(message);
    }
}
