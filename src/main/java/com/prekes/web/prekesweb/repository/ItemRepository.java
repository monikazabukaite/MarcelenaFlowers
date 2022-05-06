package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
