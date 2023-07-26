package com.wetech.core.common;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    public String getMessage(String messageId){
        return messageId;
    };

    public String getMessage(String messageId, String a) {
        return messageId + "/" + a;
    };

    public String getMessage(String messageId,String a,String b){
        return messageId + "/" + a + "/" + b;
    };

    public String getMessage(String messageId, String[] args) {
        return messageId+args.toString();
    }
}
