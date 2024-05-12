package com.lombard.service;

import com.lombard.entity.Bid;
import com.lombard.entity.User;
import com.lombard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String userName)
    {
        return userRepository.getUserByName(userName);
    }

    public void addBid(Bid bid, String name)
    {
        var user = getUserByName(name);
        user.getBids().add(bid);
        userRepository.save(user);
    }
}
