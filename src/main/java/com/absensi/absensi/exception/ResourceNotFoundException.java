package com.absensi.absensi.exception;

public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException() {

   }

   public ResourceNotFoundException(String message) {
      super(message);
   }

}
