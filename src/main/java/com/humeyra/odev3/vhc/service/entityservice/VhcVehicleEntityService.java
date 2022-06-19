package com.humeyra.odev3.vhc.service.entityservice;

import com.humeyra.odev3.gen.service.entityservice.BaseEntityService;
import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.vhc.dao.VhcVehicleDao;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VhcVehicleEntityService extends BaseEntityService<VhcVehicle, VhcVehicleDao> {
    public VhcVehicleEntityService(VhcVehicleDao dao) {
        super(dao);
    }

    public VhcVehicle findByPlate(String plate) {

        List<VhcVehicle> vhcVehicleList = super.findAll();

        if (vhcVehicleList.isEmpty()){
            throw new RuntimeException("No vehicles found!");
        }

        for (VhcVehicle vhcVehicle : vhcVehicleList) {
            if (vhcVehicle.getPlate() == plate){
                return vhcVehicle;
            }
        }

        throw new RuntimeException("No such city with given plate code exists!");

    }
    public VhcVehicle findByVehicleId(Long id) {

        List<VhcVehicle> vhcVehicleList = super.findAll();

        if (vhcVehicleList.isEmpty()){
            throw new RuntimeException("No vehicles found!");
        }

        for (VhcVehicle vhcVehicle : vhcVehicleList) {
            if (vhcVehicle.getId() == id){
                return vhcVehicle;
            }
        }

        throw new RuntimeException("No such vehicle with given id exists!");

    }
    public VhcVehicle findByUsrUser(UsrUser usrUser) {

        List<VhcVehicle> vhcVehicleList = super.findAll();

        if (vhcVehicleList.isEmpty()){
            throw new RuntimeException("No vehicles found!");
        }

        for (VhcVehicle vhcVehicle : vhcVehicleList) {
            if (vhcVehicle.getUsrUser().equals(usrUser)){
                return vhcVehicle;
            }
        }

        throw new RuntimeException("No such vehicle with given id exists!");

    }






}

