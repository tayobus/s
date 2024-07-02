package org.dojo.ezspring.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo itemRepo;

    public void saveItem(Item item) {
        itemRepo.save(item);
    }

    public void updateItem(Item item) throws NoSuchElementException {
        Optional<Item> result = itemRepo.findById(item.getId());
        if (result.isEmpty()) {
            throw new NoSuchElementException("No such item");
        } else {
            itemRepo.save(item);
        }
    }
}
