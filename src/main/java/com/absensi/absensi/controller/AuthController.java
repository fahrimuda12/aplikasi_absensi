package com.absensi.absensi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.absensi.absensi.dto.LoginDTO;
import com.absensi.absensi.dto.RegisterDTO;
import com.absensi.absensi.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   AuthService authService;

   @PostMapping("/login")
   ResponseEntity<?> Login(@RequestBody LoginDTO loginDTO) {
      return new ResponseEntity<>(authService.login(loginDTO.getNik(), loginDTO.getPassword()), HttpStatus.OK);
   }

   @PostMapping("/register")
   ResponseEntity<?> Register(@Valid @RequestBody RegisterDTO registerDTO) {
      return new ResponseEntity<>(authService.register(registerDTO), HttpStatus.OK);
   }
}
