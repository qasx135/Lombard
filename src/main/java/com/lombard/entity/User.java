package com.lombard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name", nullable=false, length=25)
    private String name;
    @Column(nullable=false)
    private String password;

    @OneToMany
    private List<Bid> bids;
}
