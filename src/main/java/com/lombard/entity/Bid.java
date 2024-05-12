package com.lombard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Bids")
@Getter
@Setter
public class Bid
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Номер заказа
    @Column(name="order_num", nullable=false)
    private int orderNum;
    @Column(name="review_date", nullable=false)
    private LocalDate reviewDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Bid() {
        this.reviewDate = LocalDate.now().plusDays(3);
    }
}
