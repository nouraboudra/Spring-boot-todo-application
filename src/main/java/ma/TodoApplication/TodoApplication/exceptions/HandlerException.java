package ma.TodoApplication.TodoApplication.exceptions;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> EntityExceptionHandler(EntityNotFoundException entityNotFoundException){

        ErrorBody errorBody = new ErrorBody(new Date(),HttpStatus.BAD_REQUEST, Arrays.asList(entityNotFoundException.getMessage()));
        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationException(ConstraintViolationException constraintViolationException) {
    Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();

    List<String> violationMessages = violations.stream()
                                               .map(ConstraintViolation::getMessage)
                                               .toList();
    ErrorBody errorBody = new ErrorBody(new Date(),HttpStatus.BAD_REQUEST,violationMessages);
        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }


}
