package com.lombard.service;

import com.lombard.entity.Bid;
import com.lombard.entity.Item;
import com.lombard.entity.ItemDTO;
import com.lombard.repository.BidRepository;
import com.lombard.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BidService
{
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;

    public boolean addBid(ItemDTO itemDTO, String userName)
    {
        try {
            var item = new Item();
            item.setTitle(itemDTO.getTitle());
            item.setDescription(itemDTO.getDescription());
            item.setCost(itemDTO.getCost());

            var bid = new Bid();
            bid.setOrderNum(getOrderNum());
            bidRepository.save(bid);
            itemRepository.save(item);

            bidRepository.getByOrderNum(bid.getOrderNum()).setItem(item);
            itemRepository.getItemByTitle(item.getTitle()).setBid(bid);
            bidRepository.save(bid);
            itemRepository.save(item);

            userService.addBid(bid, userName);

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private int getOrderNum()
    {
        var random = new Random();
        return random.nextInt(999999 - 100000 + 1) + 100000;
    }
}
