package com.humeyra.odev3.vhc.converter;

import com.humeyra.odev3.usr.converter.UsrUserMapper;
import com.humeyra.odev3.vhc.dto.VhcVehicleDto;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VhcVehicleMapper {


    VhcVehicleMapper INSTANCE = Mappers.getMapper(VhcVehicleMapper.class);


    @Mapping(source = "usrUser.id", target = "usrUserId")
    VhcVehicleDto convertToVhcVehicleDto(VhcVehicle vhcVehicle);

    @Mapping(source = "usrUserId", target = "usrUser.id")
    VhcVehicle convertToVhcVehicle(VhcVehicleDto vhcVehicleDto);

    List<VhcVehicleDto> convertToVhcVehicleDtoList(List<VhcVehicle> vhcVehicleList);

}
