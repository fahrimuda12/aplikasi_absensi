package com.absensi.absensi.model;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @ToString(of = { "code", "name" })
@Entity
@Table(name = "user")
public class UserModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @NonNull
   private Integer id;

   @Column(unique = true)
   @NonNull
   private String nik;

   @NonNull
   private String name;

   private String address;

   @NonNull
   private String email;

   @NonNull
   private String password;

   @NonNull
   @Column(name = "password_salt")
   private String passwordSalt;

   // @NonNull
   // @Column(name = "role_id")
   // private String roleId;

   @NonNull
   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updatedAt;

   @Column(name = "deleted_at")
   private LocalDateTime deletedAt;

   // @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
   // @JsonIgnore
   // private RoleModel role;
}
