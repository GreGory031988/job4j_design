package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUNKNOWN() {
        Box box = new Box(9, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisNull() {
        Box box = new Box(0, 5);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0);
    }

    @Test
    void isThisFour() {
        Box box = new Box(4, 5);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4);
    }

    @Test
    void checkBooleanFour() {
        Box box = new Box(4,12);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkBooleanTen() {
        Box box = new Box(10,12);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void areaCube() {
        Box box = new Box(8,5);
        double result = box.getArea();
        assertThat(result).isEqualTo(150d);
    }

    @Test
    void areaUnknown() {
        Box box = new Box(10,5);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }


}