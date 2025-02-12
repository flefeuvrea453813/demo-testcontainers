package com.testcontainers.demo.exception;


import org.apache.commons.lang3.StringUtils;

public class FunctionalException extends Exception {
    private static final long serialVersionUID = 1L;
    private String code;

    public FunctionalException(final String msg) {
        super(msg);
    }

    public FunctionalException(final String code, final String msg) {
        super(code + " || " + msg);
        this.code = code;
    }

    public String getCode() {
        return (String) StringUtils.defaultIfBlank(this.code, "");
    }
}