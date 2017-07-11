package task6;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class NuclearPoweredBoatTest {
    @Test
    void test() {
        NuclearPoweredBoat boat = new NuclearPoweredBoat("Titanic", "Scania", 100500);
        MatcherAssert.assertThat(boat.swim(),
                Is.is("Titanic swimming with engine NuclearPoweredBoat.Engine(name=Scania, horsepower=100500.0)"));
    }
}