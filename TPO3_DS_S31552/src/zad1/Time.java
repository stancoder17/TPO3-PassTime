/**
 *
 *  @author Dyrda Stanisław S31552
 *
 */

package zad1;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Time {
    public static String passed(String from, String to){return null;}

    public static void validate(String date1, String date2) {
        String date1Classification = classify(date1);
        String date2Classification = classify(date2);

        if (!date1Classification.equals(date2Classification)) {
            throw new RuntimeException("Dates are not of the same type");
        }
    }

    public static String classify(String date) {
        try {
            LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
            return "DATE_WITH_TIME";
        } catch (DateTimeParseException e1) {
            try {
                LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
                return "DATE_ONLY";
            } catch (DateTimeParseException e2) {
                throw new RuntimeException("Unknown date format");
            }
        }
    }
}
