package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenWith_emptyLine_and_comments() {
        String path = "./data/with_emptyLine_and_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"))
                .isEqualTo("postgres");
        assertThat("# PostgreSQL").isNotEmpty();
    }

    @Test
    void whenBreakingTheRules_key() {
        String path = "./data/breakingTheRules_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenBreakingTheRules_values() {
        String path = "./data/breakingTheRules_values.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNoSymbol() {
        String path = "./data/breakingTheRules_noSymbol.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}