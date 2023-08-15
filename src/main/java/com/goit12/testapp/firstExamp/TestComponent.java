package com.goit12.testapp.firstExamp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component // буквально створюється обьект компонента використовується рефлексія
public class TestComponent { // перевіряємо анатаціє компонент

    public TestComponent() {
        System.out.println("In constructor");
    }

    @PostConstruct // буквально виклик після конструктора,всі методи помічені цією анатоцією викликаються
    public void init() {
        System.out.println("In postconstract");
    }

    @Order(100) // викличеться в більш пізньому порядку
    @PostConstruct
    public void init2() {
        System.out.println("In init2");
    }

    @PreDestroy // виклик після виконання програми (стоп) - це та точка де можна звільнити память, ресурси...
    public void onDestroy(){
        System.out.println("In onDestroy");
    }

}
