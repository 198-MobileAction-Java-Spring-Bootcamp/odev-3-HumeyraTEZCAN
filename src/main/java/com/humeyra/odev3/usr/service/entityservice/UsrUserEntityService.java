package com.humeyra.odev3.usr.service.entityservice;

import com.humeyra.odev3.gen.service.entityservice.BaseEntityService;
import com.humeyra.odev3.usr.dao.UsrUserDao;
import com.humeyra.odev3.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {
    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public UsrUser findByUsername(String username) {

        List<UsrUser> usrUserList = super.findAll();

        if (usrUserList.isEmpty()){
            return null;
        }

        for (UsrUser usrUser : usrUserList) {
            if (usrUser.getUsername().equals(username)){
                return usrUser;
            }
        }
return null;
    }


}
