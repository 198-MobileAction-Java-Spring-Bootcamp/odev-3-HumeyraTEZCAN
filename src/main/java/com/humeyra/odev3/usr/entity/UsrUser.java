package com.humeyra.odev3.usr.entity;

import com.humeyra.odev3.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USR_USER")
public class UsrUser extends BaseEntity {
    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "LASTNAME", length = 20)
    private String lastname;

    @Column(name = "USERNAME", length = 20)
    private String username;

    @Column(name = "PASSWORD", length = 250)
    private String password;



}
