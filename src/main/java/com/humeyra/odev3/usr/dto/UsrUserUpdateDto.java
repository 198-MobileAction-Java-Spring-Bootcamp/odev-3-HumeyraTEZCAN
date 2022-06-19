package com.humeyra.odev3.usr.dto;

import lombok.Data;

@Data
public class UsrUserUpdateDto {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
}