package com.absensi.absensi.response;

public class RegisterResponse {
   private Integer id;
   private String nik;
   private String name;
   private String email;
   private String address;
   // private LocalDateTime createdAt;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNik() {
      return nik;
   }

   public void setNik(String nik) {
      this.nik = nik;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
