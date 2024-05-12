package com.lombard.repository;

import com.lombard.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Integer>
{
    Bid getByOrderNum(int orderNum);
}
