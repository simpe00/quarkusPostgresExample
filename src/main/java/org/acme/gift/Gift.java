package org.acme.gift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonPropertyOrder({"id", "name"})
@NamedQuery(name = "Gift.findAll", query = "SELECT c FROM Gift c ORDER BY c.name")
@SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
public class Gift {

    public Gift(){}

    public Gift(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(generator = "giftSeq")
    private Long id;

    private String name;
    private double price;

}
