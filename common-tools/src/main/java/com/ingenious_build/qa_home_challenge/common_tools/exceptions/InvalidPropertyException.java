package com.ingenious_build.qa_home_challenge.common_tools.exceptions;

public class InvalidPropertyException extends RuntimeException{

    public InvalidPropertyException(String string, Object... args) {
        super(string.formatted(args));
    }

}
