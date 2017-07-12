package task1;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("WeakerAccess")
public class CrazyLogger {
    private StringBuilder builder = new StringBuilder();

    public void addMessage(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm").withZone(ZoneId.systemDefault());
        builder.append(String.format("%s - %s%n", formatter.format(Instant.now()), message.replaceAll("\n", " ")));
    }

    public int search(String pattern, boolean sout) {
        int count = 0;
        for (String s : builder.toString().split("\n")) {
            if (s.contains(pattern)) {
                if (sout) {
                    System.out.println(s);
                }
                count++;
            }
        }
        return count;
    }
}
