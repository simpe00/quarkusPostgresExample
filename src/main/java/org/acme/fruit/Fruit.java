package org.acme.fruit;

public class Fruit {

    public String name;
    public String description;

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
        if (this.name.equals(((Fruit) obj).name) && this.description.equals(((Fruit) obj).description)){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode() * description.hashCode();
    }
}
