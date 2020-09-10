package com.githab.meraving.voter.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "It,s too late to change your mind!")
public class TooLateException extends RuntimeException {
}

