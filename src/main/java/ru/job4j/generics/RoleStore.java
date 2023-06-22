package ru.job4j.generics;

public class RoleStore implements Store<Role> {

    private final Store<Role> capacity = new MemStore<>();

    @Override
    public void add(Role model) {
        capacity.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return capacity.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return capacity.delete(id);
    }

    @Override
    public Role findById(String id) {
        return capacity.findById(id);
    }
}
