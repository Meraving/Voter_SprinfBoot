package com.githab.meraving.voter.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "You can vote only for today!")
public class WrongDateException extends RuntimeException {
}