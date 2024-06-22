package tech.patricknicezi.Spring.Store.bootstrap.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}
