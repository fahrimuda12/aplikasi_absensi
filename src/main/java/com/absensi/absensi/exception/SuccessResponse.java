package com.absensi.absensi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SuccessResponse {
   private final int statusCode;
   private final String message;
   private final String data;
}
