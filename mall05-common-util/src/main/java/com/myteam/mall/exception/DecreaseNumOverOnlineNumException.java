package com.myteam.mall.exception;

public class DecreaseNumOverOnlineNumException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DecreaseNumOverOnlineNumException() {
    }

    public DecreaseNumOverOnlineNumException(String message) {
        super(message);
    }

    public DecreaseNumOverOnlineNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecreaseNumOverOnlineNumException(Throwable cause) {
        super(cause);
    }

    public DecreaseNumOverOnlineNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
