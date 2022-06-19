package com.humeyra.odev3.vhc.entity;

import com.humeyra.odev3.gen.entity.BaseEntity;
import com.humeyra.odev3.usr.entity.UsrUser;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "VHC_VEHICLE")
public class VhcVehicle extends BaseEntity {

    @Id
    @SequenceGenerator(name = "VhcVehicle", sequenceName = "VHC_VEHICLE_ID_SEQ")
    @GeneratedValue(generator = "VhcVehicle")
    private Long id;

    @NotBlank
    @Pattern(regexp="^[A-Z]")
    @Column(name = "PLATE", length = 10)
    private String plate;

    @Column(name = "BRAND", length = 10)
    private String brand;

    @Column(name = "MODEL", length = 10)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_USER")
    private UsrUser usrUser;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
