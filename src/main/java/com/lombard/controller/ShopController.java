package com.lombard.controller;

import com.lombard.entity.ItemDTO;
import com.lombard.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class ShopController
{
    @Autowired
    BidService bidService;

    @GetMapping("/createbid")
    public String createBid(Model model)
    {
        model.addAttribute("item", new ItemDTO());
        return "createbid";
    }

    @PostMapping("/createbid")
    public String createBid(@ModelAttribute ItemDTO item, Principal principal)
    {
        bidService.addBid(item, principal.getName());
        return "redirect:/account";
    }
}