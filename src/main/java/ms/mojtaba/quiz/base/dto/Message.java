package ms.mojtaba.quiz.base.dto;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;

@Value
public class Message {

    LocalDate dateStamp;
    LocalTime timeStamp;
    String title;
    String message;
    String code;
}
