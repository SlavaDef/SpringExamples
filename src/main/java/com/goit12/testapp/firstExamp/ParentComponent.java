package com.goit12.testapp.firstExamp;

import com.goit12.testapp.firstExamp.ChildComponent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor // створює конструктор як знизу завдання анатоції проініцілізіювати всі файнал поля
@Component
public class ParentComponent { // нам треба отримати ChildComponent в ParentComponent

    //@Autowired // буквально дай нам такийто компонент, без все упаде, завдяки рефлексії все ок є інший шлях через конструктор
    private final ChildComponent childComponent;

  /*  public ParentComponent(ChildComponent childComponent) { // звичайний конструктор
        this.childComponent = childComponent; // в такому випадку все буде ок
    } // але якщо буде що один конструктор то будуть трабли тому допоможе анотація @Autowired


    //також можна через сетер

    @Autowired
    public void setChildComponent(ChildComponent childComponent) {
        this.childComponent = childComponent;
    }  */


    @PostConstruct
    public void inIt() {
        childComponent.hello();
    }

}
