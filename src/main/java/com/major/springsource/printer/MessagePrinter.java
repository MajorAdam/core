package com.major.springsource.printer;

import com.major.springsource.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    private MessageService messageService;
    private String string;
    private int small;
    @Autowired
    public MessagePrinter(MessageService messageService, String string) {
        this.messageService = messageService;
        this.string = string;
    }
    public void printMessage() {
        System.out.println(this.messageService.getMessage()+this.string);
    }
    public static MessagePrinter createPrinter(MessageService messageService,String string){
        return new MessagePrinter(messageService,string);
    }
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getSmall() {
        return small;
    }

    public void setSmall(int small) {
        this.small = small;
    }
}
