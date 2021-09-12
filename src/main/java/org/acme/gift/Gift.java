package org.acme.gift;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonPropertyOrder({"id", "name"})
@NamedQuery(name = "Gift.findAll", query = "SELECT c FROM Gift c ORDER BY c.name")
public class Gift {

    public Gift(){}

    public Gift(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "giftSeq")
    private Long id;
    private String name;

}
