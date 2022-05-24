package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
