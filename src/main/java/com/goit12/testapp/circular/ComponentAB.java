package com.goit12.testapp.circular;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ComponentAB {

   private final ComponentA componentA;
   private final ComponentB componentB;

@PostConstruct
    public void inIt(){
    componentA.print();

}


}
