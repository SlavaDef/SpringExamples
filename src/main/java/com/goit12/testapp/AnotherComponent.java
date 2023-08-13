package com.goit12.testapp;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AnotherComponent {

    private final ChildComponent childComponent;

@PostConstruct
    public void inIt(){
    childComponent.hello();
    System.out.println("ChildComponent from anotherComponent");
}


}
