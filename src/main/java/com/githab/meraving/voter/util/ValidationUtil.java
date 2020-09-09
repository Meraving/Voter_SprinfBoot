package com.githab.meraving.voter.util;

import com.githab.meraving.voter.util.exception.NotFoundException;

import java.util.Optional;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static <T> T getFromOptional (Optional<T> optional){
        return optional.orElseThrow(()->new NotFoundException("Object is not present"));
    }

}
