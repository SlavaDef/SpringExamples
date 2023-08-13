package com.goit12.testapp.circular;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class ComponentA {

    // не правильний дизайн системи компонент, А посилається на компонент В і навпаки зацикліваніе
    // вирішенням буде зробити третій клас і додати до нього А і В залежності
   // private final ComponentB componentB;


 /*   public ComponentA(ComponentB componentB){
        this.componentB=componentB;
          System.out.println("Creating A");
    } */
    @PostConstruct
    public void inIt(){
        System.out.println("I am component A");
    }

    public void print(){
        System.out.println("I am component A from AB");
    }

}
