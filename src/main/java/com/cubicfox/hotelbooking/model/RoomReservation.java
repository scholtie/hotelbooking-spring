package com.cubicfox.hotelbooking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="RoomReservation")
public class RoomReservation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date_in;

    private Date date_out;

    private String status;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users made_by;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
