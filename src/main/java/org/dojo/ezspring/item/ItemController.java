package org.dojo.ezspring.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepo itemRepo;
    private final ItemService itemService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", itemRepo.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepo.findById(id);
        result.ifPresent(item -> model.addAttribute("item", item));
        return "detail";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/add")
    public String writePost(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepo.findById(id);
        result.ifPresent(item -> model.addAttribute("item", item));
        return "edit";
    }

    @PostMapping("/update")
    public String updateItem(@ModelAttribute Item item) {
        itemService.updateItem(item);
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam Long id) {
        itemRepo.deleteById(id);
        return "redirect:/list";
    }
}
