package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ListUtilsTest {
    private List<Integer> input;
    private List<Integer> inputNew;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
        inputNew = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 2));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(inputNew, i -> i > 3);
        assertThat(inputNew).hasSize(3).containsSequence(1, 2, 2);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.replaceIf(inputNew, i -> i > 3, 9);
        assertThat(inputNew).hasSize(5).containsSequence(1, 9, 2, 9, 2);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, inputNew);
        assertThat(input).hasSize(1).containsSequence(3);
    }
}