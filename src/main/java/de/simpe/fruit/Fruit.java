package de.simpe.fruit;

import lombok.Data;

@Data
public class Fruit {

    private String name;
    private String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit)){ return false;}
        if (obj == this){ return true;}
        return (this.name.equals(((Fruit) obj).name) && this.description.equals(((Fruit) obj).description));
    }
    
    @Override
    public int hashCode(){
        return name.hashCode() * description.hashCode();
    }
}
