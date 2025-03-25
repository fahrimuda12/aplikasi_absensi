package com.absensi.absensi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
   @GetMapping("/")
   public String getMethodName() {
      return "Hello World";
   }

}
