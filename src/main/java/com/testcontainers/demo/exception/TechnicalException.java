package com.testcontainers.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * Cette exception est utilisée lorsque que l'on rencontre une erreur technique dans le traitement d'un service.
 *
 * @author dl-back-sgin
 *
 */
public class TechnicalException extends Exception {

    private static final long serialVersionUID = 1L;
    private final HttpStatus status;
    private final String requestId;
    private final String docNumber;

    public TechnicalException(String msg) {
        this(msg, HttpStatus.INTERNAL_SERVER_ERROR, "", "");
    }

    public TechnicalException(String msg, HttpStatus status, String requestId, String docNumber) {
        super(msg);
        this.status = status;
        this.requestId = requestId;
        this.docNumber = docNumber;
    }

    public HttpStatus getStatus() {
        return status;
    }
    public String getRequestId() {
        return requestId;
    }
    public String getDocNumber() {
        return docNumber;
    }
}