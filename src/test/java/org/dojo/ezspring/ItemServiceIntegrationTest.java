package org.dojo.ezspring;

import org.dojo.ezspring.item.Item;
import org.dojo.ezspring.item.ItemRepo;
import org.dojo.ezspring.item.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ItemServiceIntegrationTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepo itemRepo;

    @Test
    void testSaveItem() {
        Item item = new Item();
        item.setTitle("Integration Test Item");
        item.setPrice(200);

        itemService.saveItem(item);

        Optional<Item> savedItem = itemRepo.findById(item.getId());
        assertThat(savedItem).isPresent();
        assertThat(savedItem.get().getTitle()).isEqualTo("Integration Test Item");
    }
}
