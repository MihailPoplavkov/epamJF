package task6;

import lombok.Value;
import task7.Annotation;

@SuppressWarnings("WeakerAccess")
@Annotation("NuclearPoweredBoat")
public class NuclearPoweredBoat {
    private String name;
    private Engine engine;

    @Value
    private class Engine {
        private String name;
        private double horsepower;
    }

    @SuppressWarnings("unused")
    public NuclearPoweredBoat(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public NuclearPoweredBoat(String name, String engineName, double horsepower) {
        Engine engine = new Engine(engineName, horsepower);
        this.name = name;
        this.engine = engine;
    }

    public String swim() {
        return String.format("%s swimming with engine %s", name, engine.toString());
    }

    public static String getValueFromAnnotation() {
        return NuclearPoweredBoat.class
                .getAnnotation(Annotation.class)
                .value();
    }
}
