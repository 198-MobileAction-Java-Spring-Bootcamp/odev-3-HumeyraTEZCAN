package com.humeyra.odev3.usr.converter;


import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.dto.UsrUserSaveDto;
import com.humeyra.odev3.usr.dto.UsrUserUpdateDto;
import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.vhc.converter.VhcVehicleMapper;
import com.humeyra.odev3.vhc.dto.VhcVehicleDto;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {
    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);


    UsrUser convertToUsrUser(UsrUserSaveDto usrUserSaveDto);
    UsrUserDto convertToUsrUserDto(UsrUser usrUser);

    UsrUserSaveDto convertToUsrUserSaveDto(UsrUserDto usrUserDto);
/*
    UsrUser convertToCusCustomer(UsrUserUpdateDto usrUserUpdateDto);

    UsrUserSaveDto convertToUsrUserSaveDto(UsrUser usrUser);*/
    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);




}
