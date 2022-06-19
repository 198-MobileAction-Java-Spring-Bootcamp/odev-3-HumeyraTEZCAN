package com.humeyra.odev3.controllers;

import com.humeyra.odev3.gen.response.RestResponse;
import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.usr.service.UsrUserService;
import com.humeyra.odev3.vhc.dao.VhcVehicleDao;
import com.humeyra.odev3.vhc.dto.VhcVehicleDto;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import com.humeyra.odev3.vhc.service.VhcVehicleService;
import com.humeyra.odev3.vhc.service.entityservice.VhcVehicleEntityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@AllArgsConstructor
public class VhcVehicleController {

    private VhcVehicleDao vhcVehicleDao;
    private VhcVehicleService vhcVehicleService;
    private UsrUserService usrUserService;

    @PostMapping
    public ResponseEntity<VhcVehicle> saveVehicle(@RequestBody VhcVehicleDto vhcVehicleDto){

        VhcVehicle vhcVehicle = vhcVehicleService.saveVehicle(vhcVehicleDto);

        List<VhcVehicleDto> vhcVehicleDtoList = vhcVehicleService.findAllVehicles();
        if(vhcVehicleDtoList.contains(vhcVehicleDto)){
            throw  new RuntimeException("This vehicle already exists!");

        }

        return new ResponseEntity<>(vhcVehicle, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<VhcVehicleDto>> getAllVehicles(){
        List<VhcVehicleDto> vhcVehiclesDto = vhcVehicleService.findAllVehicles();

        return new ResponseEntity<>(vhcVehiclesDto, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<VhcVehicle> deleteVehicle(@RequestParam long id){

        VhcVehicle vhcVehicle = vhcVehicleDao.findById(id).orElseThrow();

        vhcVehicleDao.delete(vhcVehicle);

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatemodel/{id}/{newModel}")
    public ResponseEntity updateVehicleModel(@RequestParam long id, String newModel){


        VhcVehicleDto vhcVehicleDto =  vhcVehicleService.findVehicleById(id);

        vhcVehicleDto.setModel(newModel);

        vhcVehicleService.saveVehicle(vhcVehicleDto);

        return ResponseEntity.ok(vhcVehicleDto);


    }


    @PatchMapping("/updatebrand/{id}/{newBrand}")
    public ResponseEntity updateVehicleBrand(@RequestParam long id, String newBrand){

       VhcVehicleDto vhcVehicleDto =  vhcVehicleService.findVehicleById(id);

        vhcVehicleDto.setBrand(newBrand);

        vhcVehicleService.saveVehicle(vhcVehicleDto);

        return ResponseEntity.ok(vhcVehicleDto);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        vhcVehicleService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }


}
