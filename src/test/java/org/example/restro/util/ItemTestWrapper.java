package org.example.restro.util;

import lombok.RequiredArgsConstructor;
import org.example.restro.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemTestWrapper {

    private final ItemRepository itemRepository;

    public void deletedAll() {
        itemRepository.deleteAll();
    }

}
