package com.lombard.repository;

import com.lombard.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>
{
    Item getItemByTitle (String title);
}
