package com.absensi.absensi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.absensi.absensi.client.AuthClient;
import com.absensi.absensi.dto.RegisterDTO;
import com.absensi.absensi.exception.ResourceNotFoundException;
import com.absensi.absensi.model.UserModel;
import com.absensi.absensi.repository.UserRepository;
import com.absensi.absensi.response.RegisterResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {
   private final UserRepository userRepository;
   private AuthClient authClient;
   // private PasswordEncoder passwordEncoder;

   public AuthService(UserRepository userRepository, AuthClient authClient) {
      this.userRepository = userRepository;
      this.authClient = authClient;
      // this.passwordEncoder = passwordEncoder;
   }

   public UserModel login(String nik, String password) {
      UserModel user = userRepository.findByNik(nik).orElseThrow(() -> new ResourceNotFoundException());
      String encryptPassword = new BCryptPasswordEncoder().encode(password);
      if (user.getPassword().equals(encryptPassword)) {
         return user;
      } else {
         throw new RuntimeException("Password is incorrect");
      }
   }

   public RegisterResponse register(RegisterDTO input) {
      ResponseEntity<RegisterResponse> registerResponse = authClient.registerResource(input);

      if (registerResponse.getBody() != null) {
         RegisterResponse responseBody = registerResponse.getBody();
         return responseBody;
      } else {
         throw new RuntimeException("Failed to register user: Response body is null");
      }
   }
}
