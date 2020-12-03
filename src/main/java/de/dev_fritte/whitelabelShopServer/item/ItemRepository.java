package de.dev_fritte.whitelabelShopServer.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(long id);
    Optional<Item> findByName(String name);
}
