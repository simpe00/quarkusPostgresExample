package de.simpe.unit;

import de.simpe.fruit.Fruit;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class FruitTest {

    @Test
    public void testEqualsObj(){
        Fruit fruitReference = new Fruit("myName", "myDescription");
        Fruit fruit1 = new Fruit("myName", "myDescription");
        Fruit fruit2 = new Fruit("myName2", "myDescription2");

        assertThat(fruitReference.equals(fruit1)).isTrue();
        assertThat(fruitReference.equals(fruit2)).isFalse();

        assertThat(fruitReference.getName().equals("myName")).isTrue();
        assertThat(fruitReference.getDescription().equals("myDescription")).isTrue();
    }

}
