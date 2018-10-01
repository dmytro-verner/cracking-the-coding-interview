package chapter_3.exercise_6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnimalShelterTest {

    private AnimalShelter animalShelter;

    private Animal jayDog;
    private Animal mikkyDog;
    private Animal pinkyCat;
    private Animal cocoCat;

    @Before
    public void setUp() {
        animalShelter = new AnimalShelter();

        jayDog = new Dog("Jay");
        mikkyDog = new Dog("Mikky");
        pinkyCat = new Cat("Pinky");
        cocoCat = new Cat("Coco");
    }

    @Test
    public void dequeueCatReturnsOldestCatWhenThereAreCats() {
        animalShelter.enqueue(jayDog);
        animalShelter.enqueue(cocoCat);
        animalShelter.enqueue(pinkyCat);

        assertEquals(cocoCat, animalShelter.dequeueCat());
    }

    @Test
    public void dequeueCatReturnsCatWhenThereIsCat() {
        animalShelter.enqueue(jayDog);
        animalShelter.enqueue(cocoCat);

        assertEquals(cocoCat, animalShelter.dequeueCat());
    }

    @Test
    public void dequeueCatReturnsNullWhenThereNoCats() {
        animalShelter.enqueue(jayDog);

        assertNull(animalShelter.dequeueCat());
    }

    @Test
    public void dequeueDogReturnsOldestDogWhenThereAreDogs() {
        animalShelter.enqueue(pinkyCat);
        animalShelter.enqueue(jayDog);
        animalShelter.enqueue(mikkyDog);

        assertEquals(jayDog, animalShelter.dequeueDog());
    }

    @Test
    public void dequeueDogReturnsDogWhenThereIsDog() {
        animalShelter.enqueue(cocoCat);
        animalShelter.enqueue(mikkyDog);

        assertEquals(mikkyDog, animalShelter.dequeueDog());
    }

    @Test
    public void dequeueDogReturnsNullWhenThereNoDogs() {
        animalShelter.enqueue(cocoCat);

        assertNull(animalShelter.dequeueDog());
    }

    @Test
    public void dequeueAnyReturnsNullWhenThereAreNoCatsAndDogs() {
        assertNull(animalShelter.dequeueAny());
    }

    @Test
    public void dequeueAnyReturnsCatWhenThereIsCatAndNoDogs() {
        animalShelter.enqueue(cocoCat);

        assertEquals(cocoCat, animalShelter.dequeueAny());
    }

    @Test
    public void dequeueAnyReturnsDogWhenThereIsDogAndNoCats() {
        animalShelter.enqueue(jayDog);

        assertEquals(jayDog, animalShelter.dequeueAny());
    }

    @Test
    public void dequeueAnyReturnsDogWhenThereAreDogsAndCatsWhenDogIsTheOldest() {
        animalShelter.enqueue(mikkyDog);
        animalShelter.enqueue(cocoCat);
        animalShelter.enqueue(jayDog);

        assertEquals(mikkyDog, animalShelter.dequeueAny());
    }

    @Test
    public void dequeueAnyReturnsCatWhenThereAreDogsAndCatsWhenCatIsTheOldest() {
        animalShelter.enqueue(cocoCat);
        animalShelter.enqueue(pinkyCat);
        animalShelter.enqueue(jayDog);

        assertEquals(cocoCat, animalShelter.dequeueAny());
    }
}
