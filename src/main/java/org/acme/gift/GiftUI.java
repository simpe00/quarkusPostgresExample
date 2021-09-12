package org.acme.gift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"name", "price"})
public class GiftUI {

    public GiftUI(){
    }

    public GiftUI(String name, double price){
        this.name = name;
        this.price= price;
    }

    private String name;
    private double price;
}
