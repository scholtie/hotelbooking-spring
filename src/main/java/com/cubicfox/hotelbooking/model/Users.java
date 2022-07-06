package com.cubicfox.hotelbooking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name="Users")
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;

    private String email;

    private String password;

    private Timestamp create_time;

    private String firstName;

    private String lastName;

}
