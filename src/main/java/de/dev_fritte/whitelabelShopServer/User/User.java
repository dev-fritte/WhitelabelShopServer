package de.dev_fritte.whitelabelShopServer.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * @author schmidt.patrick.14@gmail.com
 * 03.12.2020
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;

    private String surname;

    private LocalDateTime creationDate;

    @PrePersist
    private void setCreationDate() {
        creationDate = LocalDateTime.now();
    }

}
