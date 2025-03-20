package com.absensi.absensi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @AllArgsConstructor
public class RegisterDTO {

   @Size(min = 4, max = 6, message = "nik must be between 4 and 6 characters")
   @NotNull(message = "nik must not be null")
   private String nik;
   // custom response message

   @NotNull(message = "name must not be null")
   private String name;

   @Size(min = 8, message = "password must be minimum 8 characters")
   private String password;

   @Email
   @NotNull(message = "email must not be null")
   private String email;

   @NotNull(message = "address must not be null")
   private String address;

   public String getNik() {
      return nik;
   }

   public void setNik(String nik) {
      this.nik = nik;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPassword() {
      return password;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getEmail() {
      return email;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getAddress() {
      return address;
   }

}
