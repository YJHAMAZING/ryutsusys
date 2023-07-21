package com.wetech.core.common;

public class ApiException extends Exception{
    public ApiException(){
        super();
    }

    public ApiException(String messageId) {
        super(messageId);
    }

    public ApiException(String messageId,String message){
        super(messageId+message);
        System.out.println(messageId+message);
    }
}
