package task4;

import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("WeakerAccess")
@Data
public class Actor implements Serializable {
    private String name;
    private int yearOfBirth;
    private String country;
    private transient int age;

    public Actor(String name, int yearOfBirth, String country) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
        //:)
        this.age = 2017 - yearOfBirth;
    }
}
