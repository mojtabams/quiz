package ms.mojtaba.quiz.base.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*@ControllerAdvice
public class PatientNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NoDataFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String patientNotFoundHandler(NoDataFoundException ex) {
        return ex.getMessage();
    }
}*/
