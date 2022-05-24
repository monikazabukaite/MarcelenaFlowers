package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    public Item findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item add(Item item) {
        return itemRepository.save(item);
    }

    public void update(Item item) {
        itemRepository.save(item);
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }

    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }
}
