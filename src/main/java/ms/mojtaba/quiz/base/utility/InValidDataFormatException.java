package ms.mojtaba.quiz.base.utility;

public class InValidDataFormatException extends Exception {

    public InValidDataFormatException() {
        super("Wrong entered data format!");
    }

    public InValidDataFormatException(String message) {
        super("Wrong entered data format for " + message + "!");
    }

    public InValidDataFormatException(Throwable cause) {
        super(cause);
    }

    public InValidDataFormatException(String message, Throwable cause) {
        super("Wrong entered data format for " + message + "!", cause);
    }
}