package com.goit12.testapp.circular;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

//@DependsOn("componentA") // цей компонент буде створюватися після компоненту А
@Service
public class ComponentB {

    @PostConstruct
    public void inIt(){
        System.out.println("I am component B");
    }

   // private final ComponentA componentA;

  /*  private final ApplicationContext context;

    public ComponentB(ApplicationContext context) {
             this.context = context;
        System.out.println("Creating component B");

    }



   private ComponentA getComponentA(){
      return context.get
              //getMimeType(ComponentA.class)
             // .values().stream().findFirst().orElse(null);
    } */

}
