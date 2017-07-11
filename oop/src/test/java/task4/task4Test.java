package task4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task3.*;

import java.util.Arrays;

class task4Test {
    private static LittlePen littlePen = new LittlePen();
    private static Chancery[] source = {
            new LittlePen(),
            new BigPen(),
            new SoftPencil(),
            new HardPencil(),
            littlePen,
            new HardPencil(),
            new HardPencil()
    };
    private Chancery[] kit;
    private task4 task = new task4();

    @BeforeEach
    void initArray() {
        kit = Arrays.copyOf(source, source.length);
    }

    @Test
    void sortByName() {
        task.sortByName(kit);
        String expected = "BigPen1, HardPencil1, HardPencil2, HardPencil3, LittlePen1, LittlePen2, SoftPencil1";
        String result = reduceResult(kit);
        MatcherAssert.assertThat(result, Is.is(expected));
    }

    @Test
    void sortByPrice() {
        task.sortByPrice(kit);
        String expected = "LittlePen2, LittlePen1, HardPencil1, HardPencil2, HardPencil3, SoftPencil1, BigPen1";
        String result = reduceResult(kit);
        MatcherAssert.assertThat(result, Is.is(expected));
    }

    @Test
    void sortByPriceAndName() {
        task.sortByPriceAndName(kit);
        String expected = "LittlePen1, LittlePen2, HardPencil1, HardPencil2, HardPencil3, SoftPencil1, BigPen1";
        String result = reduceResult(kit);
        MatcherAssert.assertThat(result, Is.is(expected));
    }

    private String reduceResult(Chancery[] kit) {
        //noinspection ConstantConditions
        return Arrays.stream(kit)
                .map(Chancery::getName)
                .reduce((String a, String b) -> String.format("%s, %s", a, b))
                .get();
    }
}