package org.dojo.ezspring;

import org.dojo.ezspring.item.Item;
import org.dojo.ezspring.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ItemControllerTest {

    @Autowired
    private ItemService itemService;

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/update")
    public String updateItem(@ModelAttribute Item item) {
        itemService.updateItem(item);
        return "redirect:/list";
    }
}
