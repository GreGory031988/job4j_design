package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsActor() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        Role result = capacity.findById("1");
        assertThat(result.getRolename()).isEqualTo("Actor");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        Role result = capacity.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsActor() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        capacity.add(new Role("1", "Actress"));
        Role result = capacity.findById("1");
        assertThat(result.getRolename()).isEqualTo("Actor");
    }

    @Test
    void whenReplaceThenUsernameIsActress() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        capacity.replace("1", new Role("1", "Actress"));
        Role result = capacity.findById("1");
        assertThat(result.getRolename()).isEqualTo("Actress");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        capacity.replace("10", new Role("10", "Actress"));
        Role result = capacity.findById("1");
        assertThat(result.getRolename()).isEqualTo("Actor");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        capacity.delete("1");
        Role result = capacity.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsActor() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        capacity.delete("10");
        Role result = capacity.findById("1");
        assertThat(result.getRolename()).isEqualTo("Actor");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        boolean result = capacity.replace("1", new Role("1", "Actress"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        boolean result = capacity.replace("10", new Role("10", "Actress"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        boolean result = capacity.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore capacity = new RoleStore();
        capacity.add(new Role("1", "Actor"));
        boolean result = capacity.delete("2");
        assertThat(result).isFalse();
    }
}