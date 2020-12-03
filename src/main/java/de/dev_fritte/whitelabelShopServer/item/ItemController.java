package de.dev_fritte.whitelabelShopServer.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Patrick Schmidt
 * 27.11.2020
 **/
@Controller("/items")
public class ItemController {

    private ItemRepository itemRepo;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        itemRepo = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

}
