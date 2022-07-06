package com.cubicfox.hotelbooking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="Room")
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    private Long id;

    private Character number;

    private Double pricePerDay;

    private String status;

}
