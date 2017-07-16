package task4;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmSetTest {
    @SneakyThrows
    @Test
    void testSerializable() {
        Actor RDdj = new Actor("Robert Downey jr", 1965, "USA");
        Actor MW = new Actor("Mark Wahlberg", 1971, "USA");
        Actor YN = new Actor("Yuri Nikulin", 1921, "USSR");

        Film americanFilm = new Film("American", 2017, "USA", RDdj, MW);
        Film allFilm = new Film("All", 1980, "World", RDdj, MW, YN);

        FilmSet filmSet = new FilmSet(americanFilm, allFilm);

        File file = new File("src/test/resources/output");
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(filmSet);
        output.close();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        FilmSet set = (FilmSet)input.readObject();
        input.close();
        //noinspection ResultOfMethodCallIgnored
        file.delete();

        assertEquals(filmSet, set);
    }
}