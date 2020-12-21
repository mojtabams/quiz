package ms.mojtaba.quiz.base.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {

    private final Long statusCode;

    public NoDataFoundException(Long statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public NoDataFoundException(String message, Long statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public NoDataFoundException(Throwable cause, Long statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public NoDataFoundException(String message, Throwable cause, Long statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public Long getStatusCode() {
        return this.statusCode;
    }
}
