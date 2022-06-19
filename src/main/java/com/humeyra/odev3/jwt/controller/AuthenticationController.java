package com.humeyra.odev3.jwt.controller;


import com.humeyra.odev3.gen.response.RestResponse;
import com.humeyra.odev3.jwt.dto.JwtLoginRequestDto;
import com.humeyra.odev3.jwt.service.AuthenticationService;
import com.humeyra.odev3.usr.dto.UsrUserDto;
import com.humeyra.odev3.usr.dto.UsrUserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity save(@Valid @RequestBody UsrUserSaveDto usrUserSaveDto){

        UsrUserDto usrUserDto = authenticationService.register(usrUserSaveDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }
/**/
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtLoginRequestDto jwtLoginRequestDto){

        String login = authenticationService.login(jwtLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(login));
    }
}
