package com.humeyra.odev3.usr.dao;

import com.humeyra.odev3.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrUserDao extends JpaRepository<UsrUser, Long> {
}
