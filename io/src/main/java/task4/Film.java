package task4;

import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@Value
public class Film implements Serializable {
    private String name;
    private int year;
    private String country;
    private List<Actor> actors;

    public Film(String name, int year, String country, List<Actor> actors) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.actors = actors;
    }

    @SuppressWarnings("unused")
    public Film(String name, int year, String country) {
        this(name, year, country, new ArrayList<>());
    }

    public Film(String name, int year, String country, Actor ... actors) {
        this(name, year, country, new ArrayList<>(Arrays.asList(actors)));
    }
}
