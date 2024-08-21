package org.example.restro.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.restro.exception.BixException;
import org.example.restro.model.Item;
import org.example.restro.repository.ItemRepository;
import org.example.restro.service.ItemService;
import org.example.restro.util.CustomBeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.example.restro.exception.CommonApiResultCode.INVALID_ITEM_ID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    public final ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems(List<Long> ids) {
        return itemRepository.findAllById(ids);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Item updateItem(Item item) {
        Item itemFromDb = itemRepository.findById(item.getId()).orElse(null);
        if (Objects.nonNull(itemFromDb)) {
            CustomBeanUtils.copyNonNullProperties(item, itemFromDb);
        } else {
            throw BixException.of(INVALID_ITEM_ID);
        }
        return itemRepository.saveAndFlush(itemFromDb);
    }

}
