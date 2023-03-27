package com.ingenious_build.qa_home_challenge.common_tools.exceptions;

public class UnknownPropertyException extends RuntimeException{

    public UnknownPropertyException(String string, Object... args) {
        super(string.formatted(args));
    }

}
