package com.absensi.absensi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absensi.absensi.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
   Optional<UserModel> findByNik(String nik);
}
