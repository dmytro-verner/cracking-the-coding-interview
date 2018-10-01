package chapter_3.exercise_6;

import java.util.Objects;

public abstract class Animal {

    private int order;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean isOlderThat(Animal animal) {
        return this.order < animal.getOrder();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }
}
