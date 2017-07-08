import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {
    @Test
    void addGetDelete() {
        Notebook notebook = new Notebook(10);
        Record rec1 = new Record("rec1");
        Record rec2 = new Record("rec2");
        notebook.addRecord(rec1);
        assertThrows(IllegalArgumentException.class, () -> notebook.addRecord(rec1));
        notebook.addRecord(rec2);
        Record[] records = notebook.getRecords();
        MatcherAssert.assertThat("rec1", Is.is(records[0].getText()));
        MatcherAssert.assertThat("rec2", Is.is(records[1].getText()));
        notebook.deleteRecord(rec1.getId());
        MatcherAssert.assertThat("rec2", Is.is(notebook.getRecords()[0].getText()));
        assertEquals(notebook.getSize(), 1);
        assertEquals(false, notebook.deleteRecord(rec1.getId()));
    }

    @Test
    void change() {
        Notebook notebook = new Notebook(10);
        int id = notebook.addRecord("rec");
        MatcherAssert.assertThat("rec", Is.is(notebook.getRecords()[0].getText()));
        notebook.changeRecord(id, new Record("RECORD"));
        MatcherAssert.assertThat("RECORD", Is.is(notebook.getRecords()[0].getText()));
    }
}