package com.absensi.absensi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.absensi.absensi.dto.RegisterDTO;
import com.absensi.absensi.response.RegisterResponse;

@FeignClient(name = "auth-service", url = "http://localhost:8082")
public interface AuthClient {
   @GetMapping("/auth/register")
   ResponseEntity<RegisterResponse> registerResource(@RequestBody RegisterDTO registerDTO);
}
