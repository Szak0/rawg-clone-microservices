package com.rawg.gameservice.error;

public class ErrorInfo {
    public final String detail;

    public ErrorInfo(Exception ex) {
        this.detail = ex.getLocalizedMessage();
    }
}
