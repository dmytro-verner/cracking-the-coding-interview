package chapter_3.exercise_6;

import java.util.LinkedList;

public class AnimalShelter {

    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int count;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        animal.setOrder(count++);

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Cat cat = cats.peek();
        Dog dog = dogs.peek();
        if (cat.isOlderThat(dog)) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }
}
