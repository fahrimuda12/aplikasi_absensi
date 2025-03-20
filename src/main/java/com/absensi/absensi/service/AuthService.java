package com.absensi.absensi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.absensi.absensi.dto.LoginDTO;
import com.absensi.absensi.dto.RegisterDTO;
import com.absensi.absensi.exception.ResourceNotFoundException;
import com.absensi.absensi.model.UserModel;
import com.absensi.absensi.repository.UserRepository;

@Service
public class AuthService {
   @Autowired
   private final UserRepository userRepository;
   // private final PasswordEncoder passwordEncoder;

   public AuthService(UserRepository userRepository) {
      this.userRepository = userRepository;
      // this.passwordEncoder = passwordEncoder;
   }

   public LoginDTO login(String nik, String password) {
      UserModel user = userRepository.findByNik(nik).orElseThrow(() -> new ResourceNotFoundException());
      if (user.getPassword().equals(password)) {
         return new LoginDTO(user);
      } else {
         throw new RuntimeException("Password is incorrect");
      }
   }

   public UserModel register(RegisterDTO input) {
      UserModel user = new UserModel();

      // String hex = Integer.toHexString((int) (Math.random() * 1000000));
      // String salt = Base64.getEncoder().encodeToString(input.getPassword() +
      // hex.getBytes());
      String encryptedPassword = new BCryptPasswordEncoder().encode(input.getPassword());
      user.setName(input.getName());
      user.setNik(input.getNik());
      user.setPassword(encryptedPassword);
      user.setEmail(input.getEmail());
      user.setAddress(input.getAddress());
      user.setCreatedAt(LocalDateTime.now());
      return userRepository.save(user);
   }
}
