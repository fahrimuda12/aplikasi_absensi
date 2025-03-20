package com.absensi.absensi.dto;

import com.absensi.absensi.model.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {

   private String nik;
   private String password;

   public LoginDTO(UserModel userModel) {
      this.nik = userModel.getNik();
      this.password = userModel.getPassword();
   }
}
