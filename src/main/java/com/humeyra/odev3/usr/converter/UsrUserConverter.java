package com.humeyra.odev3.usr.converter;


import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.dto.UsrUserSaveDto;
import org.springframework.stereotype.Service;

@Service
public class UsrUserConverter {

    public UsrUserSaveDto convertToUserDto(UsrUserDto usrUserDto){
        UsrUserSaveDto usrUserSaveDto = new UsrUserSaveDto();
        usrUserSaveDto.setName(usrUserDto.getName());
        usrUserSaveDto.setLastname(usrUserDto.getLastname());
        usrUserSaveDto.setPassword(usrUserDto.getPassword());
        usrUserSaveDto.setUsername(usrUserDto.getPassword());

        return usrUserSaveDto;

    }



}
