package ac.rs.metropolitan.it355pz.exceptions;

import ac.rs.metropolitan.it355pz.exceptions.custom.ConflictException;
import ac.rs.metropolitan.it355pz.exceptions.custom.ForbiddenException;
import ac.rs.metropolitan.it355pz.exceptions.custom.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<ApiErrorResponse> handleConflictException(Exception e) {
        HttpStatus status = HttpStatus.CONFLICT;
        ApiErrorResponse response = new ApiErrorResponse(e.getMessage(), status, ZonedDateTime.now());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiErrorResponse response = new ApiErrorResponse(e.getMessage(), status, ZonedDateTime.now());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    public ResponseEntity<ApiErrorResponse> handleForbiddenException(Exception e) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ApiErrorResponse response = new ApiErrorResponse(e.getMessage(), status, ZonedDateTime.now());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class, DataIntegrityViolationException.class})
    public ResponseEntity<ApiErrorResponse> handleSqlConstraintException() {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ApiErrorResponse response = new ApiErrorResponse("Parent row can't be deleted or updated", status, ZonedDateTime.now());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ApiErrorResponse> handle(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "";

        if (e instanceof MethodArgumentTypeMismatchException) {
            message = "The provided path argument is not a valid type";
        } else if (e instanceof HttpMessageNotReadableException) {
            message = "Entered value is not a valid type";
        }

        ApiErrorResponse response = new ApiErrorResponse(message, status, ZonedDateTime.now());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
