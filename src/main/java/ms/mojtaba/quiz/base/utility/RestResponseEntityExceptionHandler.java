package ms.mojtaba.quiz.base.utility;

import ms.mojtaba.pharmacy.base.dto.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalTime;

@ControllerAdvice //global exception handler
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /* Http Request Method Not Supported */
    @Override
    protected final ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Message bodyOfRequest = new Message(LocalDate.now(),
                LocalTime.now(),
                "HttpRequestMethodNotSupported",
                ex.getMessage(), "400");
        return new ResponseEntity<>(bodyOfRequest, HttpStatus.BAD_REQUEST);
    }

    /* No Data Found Exception */
    @ExceptionHandler(value = {NoDataFoundException.class})
    protected final ResponseEntity<Message> handleNoDataFound(NoDataFoundException ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        Message bodyOfRequest = new Message(LocalDate.now(),
                LocalTime.now(),
                "NoDataFound",
                ex.getMessage(), "404");
        return new ResponseEntity<>(bodyOfRequest, responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected final ResponseEntity<Message> handleConstraintViolation(ConstraintViolationException ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        Message bodyOfRequest = new Message(LocalDate.now(),
                LocalTime.now(),
                "ConstraintViolation",
                ex.getMessage(), "400");
        return new ResponseEntity<>(bodyOfRequest, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected final ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        Message bodyOfRequest = new Message(LocalDate.now(),
                LocalTime.now(),
                "IllegalArgument|IllegalState",
                ex.getMessage(), "409");
        return handleExceptionInternal(ex, bodyOfRequest, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
