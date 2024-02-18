package ma.TodoApplication.TodoApplication.exceptions;

public class ValidationErrorException extends Exception{
    public ValidationErrorException(String message) {
        super(message);
    }
}
