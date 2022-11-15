package com.niit.jap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Already Exist ")
public class CustomerAlreadyExistException extends Exception{
}
