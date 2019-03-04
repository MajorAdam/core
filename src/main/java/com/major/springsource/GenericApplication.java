package com.major.springsource;

import com.major.springsource.service.MessageService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class GenericApplication {
    public static void main(String[] args) {
//        Within the container itself, these bean definitions are represented as BeanDefinition objects, which contain (among other information) the following metadata:
//        A package-qualified class name: typically the actual implementation class of the bean being defined.
//        Bean behavioral configuration elements, which state how the bean should behave in the container (scope, lifecycle callbacks, and so forth).
//        References to other beans that are needed for the bean to do its work; these references are also called collaborators or dependencies.
//        Other configuration settings to set in the newly created object, for example, the number of connections to use in a bean that manages a connection pool, or the size limit of the pool.

        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("appContext.xml");
        context.refresh();
        MessageService messageService = context.getBean("messageService", MessageService.class);

        System.out.println(messageService.getMessage());
    }
}
