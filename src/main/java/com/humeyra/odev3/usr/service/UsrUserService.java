package com.humeyra.odev3.usr.service;




import com.humeyra.odev3.usr.converter.UsrUserMapper;
import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.dto.UsrUserSaveDto;
import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.usr.service.entityservice.UsrUserEntityService;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import com.humeyra.odev3.vhc.service.VhcVehicleService;
import com.humeyra.odev3.vhc.service.entityservice.VhcVehicleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;
    private final VhcVehicleEntityService vhcVehicleEntityService;
    private  final PasswordEncoder passwordEncoder;


    public List<UsrUserDto> findAllUsers(){
        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        List<UsrUserDto> countryDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);

        return countryDtoList;

    }
    public UsrUserDto saveUser(UsrUserSaveDto usrUserSaveDto) {
        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveDto);

        if(usrUserEntityService.findByUsername(usrUser.getUsername()) != null){
            throw new RuntimeException("Choose another user name!");
        }

            String password = passwordEncoder.encode(usrUser.getPassword());
            usrUser.setPassword(password);
            usrUser = usrUserEntityService.save(usrUser);
            UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }
    public UsrUserDto saveUserUpdate(UsrUserSaveDto usrUserSaveDto) {
        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveDto);


        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);
        usrUser = usrUserEntityService.save(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }
    public void delete(Long id) {

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        usrUserEntityService.delete(usrUser);
        VhcVehicle vhcVehicle =  vhcVehicleEntityService.findByUsrUser(usrUser);
        vhcVehicleEntityService.delete(vhcVehicle);


    }


    public UsrUserDto findUserByUsername(String username){
        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }
    public UsrUserDto findUserById(Long id){
        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }




}
