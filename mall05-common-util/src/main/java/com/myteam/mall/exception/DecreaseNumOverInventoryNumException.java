package com.myteam.mall.exception;

public class DecreaseNumOverInventoryNumException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DecreaseNumOverInventoryNumException() {
    }

    public DecreaseNumOverInventoryNumException(String message) {
        super(message);
    }

    public DecreaseNumOverInventoryNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecreaseNumOverInventoryNumException(Throwable cause) {
        super(cause);
    }

    public DecreaseNumOverInventoryNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
