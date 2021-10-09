package com.myteam.mall.exception;

public class ShopAcctAlreadyInUseException extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public ShopAcctAlreadyInUseException() {
    }

    public ShopAcctAlreadyInUseException(String message) {
        super(message);
    }

    public ShopAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    public ShopAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
