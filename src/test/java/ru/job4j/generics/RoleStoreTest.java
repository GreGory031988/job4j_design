package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsActor() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Actor");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        User result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsActor() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        store.add(new User("1", "Actress"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Actor");
    }

    @Test
    void whenReplaceThenUsernameIsActress() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        store.replace("1", new User("1", "Actress"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Actress");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        store.replace("10", new User("10", "Actress"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Actor");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        store.delete("1");
        User result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsActor() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Actor");
    }

    @Test
    void whenReplaceOkThenTrue() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        boolean result = store.replace("1", new User("1", "Actress"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        boolean result = store.replace("10", new User("10", "Actress"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        boolean result = store.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        UserStore store = new UserStore();
        store.add(new User("1", "Actor"));
        boolean result = store.delete("2");
        assertThat(result).isFalse();
    }
}