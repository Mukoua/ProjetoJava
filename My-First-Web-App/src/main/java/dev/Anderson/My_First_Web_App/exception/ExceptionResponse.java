package dev.Anderson.My_First_Web_App.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {


}
