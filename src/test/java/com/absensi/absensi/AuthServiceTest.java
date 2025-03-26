package com.absensi.absensi;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.absensi.absensi.controller.AuthController;
import com.absensi.absensi.dto.RegisterDTO;
import com.absensi.absensi.response.RegisterResponse;
import com.absensi.absensi.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthServiceTest {

   @Autowired
   private MockMvc mockMvc;

   @Mock
   private AuthService authService;

   @InjectMocks
   private AuthController authController;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
   }

   @Test
   void testRegisterSuccess() throws Exception {
      // Test register success
      RegisterDTO registerDTO = new RegisterDTO("12345", "test", "test1234", "testDev@gmail.com", "testsaddas");

      // // simulais service dipanggil dengan benar
      RegisterResponse registerResponse = new RegisterResponse();
      when(authService.register(any(RegisterDTO.class))).thenReturn(registerResponse);

      // test performance
      mockMvc.perform(post("/auth/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(registerDTO)))
            .andExpect(status().isOk());

      verify(authService, times(1)).register(any(RegisterDTO.class));
   }
}
