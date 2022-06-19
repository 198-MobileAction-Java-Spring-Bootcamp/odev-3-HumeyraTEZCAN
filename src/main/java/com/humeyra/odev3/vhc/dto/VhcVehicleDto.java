package com.humeyra.odev3.vhc.dto;

import lombok.Data;

@Data
public class VhcVehicleDto {
    private Long id;
    private String plate;
    private String brand;
    private String model;
    private Long usrUserId;
}
