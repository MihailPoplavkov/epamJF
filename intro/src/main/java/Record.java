import lombok.Getter;
import lombok.ToString;

/**
 * Class {@code Record} represents record into notebook.
 * @author mihailpoplavkov
 * @version 1.0
 * @since 2017-07-08
 * @see Notebook
 */

@SuppressWarnings("WeakerAccess")
@Getter
@ToString
public class Record {
    private static int idCounter = 1;
    private int id;
    private String text;

    /**
     * Creates new record with the given {@code text}.
     * It marked new record with the unique id.
     * @param text text to create record with
     */
    public Record(String text) {
        id = idCounter++;
        this.text = text;
    }
}
