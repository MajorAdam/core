package com.major.springsource.service;

public class MessageServiceImpl implements MessageService {
    private static MessageService messageService = new MessageServiceImpl();
    public String getMessage() {
        return "hello world";
    }
    public static MessageService createInstance(){
        return messageService;
    }
}
