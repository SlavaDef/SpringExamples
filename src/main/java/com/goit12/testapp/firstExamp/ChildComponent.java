package com.goit12.testapp.firstExamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype") // з цією анатацією кожній клас буду створювати новий обьект
@Component
public class ChildComponent {

    public ChildComponent(){ // переконуємося що ChildComponent створюється лише один раз хоча його юзають два класи
        System.out.println("from childComponent constructor");
    }
    public void hello(){
        System.out.println("Hello, I am child component");
    }
}
