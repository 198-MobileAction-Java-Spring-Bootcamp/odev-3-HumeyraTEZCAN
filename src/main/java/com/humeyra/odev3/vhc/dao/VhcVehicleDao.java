package com.humeyra.odev3.vhc.dao;

import com.humeyra.odev3.vhc.entity.VhcVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VhcVehicleDao extends JpaRepository<VhcVehicle, Long> {
}
