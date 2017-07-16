package task4;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
@Data
public class FilmSet implements Serializable {
    private Set<Film> films;

    public FilmSet(Film ... films) {
        this.films = new HashSet<>(Arrays.asList(films));
    }
}
