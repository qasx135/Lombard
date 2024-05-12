package com.lombard.entity;

import lombok.*;

@Getter
@Setter
public class ItemDTO
{
    private String title;
    private String description;
    private int cost;

    public ItemDTO() {

    }
}
