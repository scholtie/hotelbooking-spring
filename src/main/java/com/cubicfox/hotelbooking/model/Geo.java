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
@Table(name="Geo")
public class Geo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Double lat;

    private Double lng;

}
