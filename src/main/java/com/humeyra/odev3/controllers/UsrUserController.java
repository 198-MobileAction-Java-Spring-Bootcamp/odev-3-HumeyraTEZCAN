package com.humeyra.odev3.controllers;


import com.humeyra.odev3.gen.response.RestResponse;
import com.humeyra.odev3.usr.converter.UsrUserConverter;
import com.humeyra.odev3.usr.converter.UsrUserMapper;
import com.humeyra.odev3.usr.dao.UsrUserDao;
import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.dto.UsrUserSaveDto;
import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.usr.service.UsrUserService;
import com.humeyra.odev3.vhc.dto.VhcVehicleDto;
import com.humeyra.odev3.vhc.entity.VhcVehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsrUserController {
    private UsrUserDao usrUserDao;
    private UsrUserService usrUserService;
    private PasswordEncoder passwordEncoder;
    private UsrUserConverter usrUserConverter;


    @PostMapping
    public ResponseEntity<RestResponse<UsrUserDto>> saveUser(@RequestBody UsrUserSaveDto usrUserSaveDto) {

        UsrUserDto usrUserDto = usrUserService.saveUser(usrUserSaveDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));

    }


    @GetMapping
    public ResponseEntity<List<UsrUser>> getAllUsers(){

        List<UsrUser> userList = usrUserDao.findAll();

        return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsrUser> getUserById(@RequestParam long id){
        UsrUser user = usrUserDao.findById(id).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<UsrUser> updateUser(@RequestBody UsrUser usrUser){

        boolean isExists = usrUserDao.existsById(usrUser.getId());

        if (!isExists){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        usrUser = usrUserDao.save(usrUser);

        return new ResponseEntity<>(usrUser, HttpStatus.ACCEPTED);
    }
   /**/ @PatchMapping("/changepassword/{id}/{oldpassword}/{newpassword}/{newpasswordagain}")
    public ResponseEntity changePassword(@RequestParam long id, String oldpassword, String newpassword, String newpasswordagain){


        UsrUserDto usrUserDto =  usrUserService.findUserById(id);


        if( passwordEncoder.matches(oldpassword, usrUserDto.getPassword())){

            if(newpassword.equals(newpasswordagain)){
                usrUserDto.setPassword(newpassword);
               UsrUserSaveDto usrUserSaveDto = usrUserConverter.convertToUserDto(usrUserDto);
                usrUserService.saveUserUpdate(usrUserSaveDto);
            }
            else {
                throw new RuntimeException("new passwords does not match!");
            }
        }
        else {
            throw new RuntimeException("Your old password is wrong!");
        }



        return ResponseEntity.ok(usrUserDto);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        usrUserService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }









}