package com.lombard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Items")
@Getter
@Setter
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, length=25)
    private String title;
    @Column(nullable=false, length=100)
    private String description;
    @Column(nullable=false)
    private int cost;

    @OneToOne(fetch = FetchType.LAZY)
    private Bid bid;

    public Item() {

    }
}
