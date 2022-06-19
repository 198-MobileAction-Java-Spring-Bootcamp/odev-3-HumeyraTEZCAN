package com.humeyra.odev3.vhc.service;


import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.vhc.converter.VhcVehicleMapper;
import com.humeyra.odev3.vhc.dto.VhcVehicleDto;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import com.humeyra.odev3.vhc.service.entityservice.VhcVehicleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VhcVehicleService {


    private final VhcVehicleEntityService vhcVehicleEntityService;


    public List<VhcVehicleDto> findAllVehicles(){

        List<VhcVehicle> vhcVehicleList = vhcVehicleEntityService.findAll();


        List<VhcVehicleDto> vhcVehicleDtoList = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDtoList(vhcVehicleList);

        return vhcVehicleDtoList;

    }

    public VhcVehicleDto findVehicleByPlate(String plate){

        VhcVehicle vhcVehicle = vhcVehicleEntityService.findByPlate(plate);

        VhcVehicleDto vhcVehicleDto = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDto(vhcVehicle);

        return vhcVehicleDto;
    }

    public VhcVehicleDto findVehicleById(Long id){

        VhcVehicle vhcVehicle = vhcVehicleEntityService.findByVehicleId(id);

        VhcVehicleDto vhcVehicleDto = VhcVehicleMapper.INSTANCE.convertToVhcVehicleDto(vhcVehicle);

        return vhcVehicleDto;
    }

    public VhcVehicle saveVehicle(VhcVehicleDto vhcVehicleDto){

        VhcVehicle vhcVehicle = VhcVehicleMapper.INSTANCE.convertToVhcVehicle(vhcVehicleDto);

        vhcVehicleEntityService.save(vhcVehicle);

        return vhcVehicle;

    }
    public void delete(Long id) {

        VhcVehicle vhcVehicle = vhcVehicleEntityService.findByIdWithControl(id);

        vhcVehicleEntityService.delete(vhcVehicle);

    }
}

