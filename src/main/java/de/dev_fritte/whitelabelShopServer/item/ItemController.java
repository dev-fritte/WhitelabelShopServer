package de.dev_fritte.whitelabelShopServer.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Patrick Schmidt
 * 27.11.2020
 **/
@Slf4j
@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemRepository itemRepo;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        itemRepo = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        log.debug("get all Items()");
        return itemRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

}
