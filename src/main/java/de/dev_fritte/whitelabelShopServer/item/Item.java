package de.dev_fritte.whitelabelShopServer.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Patrick Schmidt
 * 27.11.2020
 **/
@Data
@Entity
@Table(name = "item")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title", length = 100, unique = true, nullable = false)
    private String name;

    private String comment;

    private float costs;
}
