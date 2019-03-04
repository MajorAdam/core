package com.major.springsource;

import com.major.springsource.printer.MessagePrinter;
import com.major.springsource.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
       MessageService messageService = context.getBean("mService",MessageService.class);
        MessagePrinter messagePrinter = context.getBean("messagePrinter",MessagePrinter.class);
        messagePrinter.printMessage();
        System.out.println(messageService.getMessage());
        System.out.println(messagePrinter.getString());
        System.out.println(messagePrinter.getSmall());
        System.out.println(messagePrinter.getString());

    }
}
