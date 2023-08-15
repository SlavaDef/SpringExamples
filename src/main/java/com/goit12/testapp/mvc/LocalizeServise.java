package com.goit12.testapp.mvc;

import org.springframework.stereotype.Service;

@Service
public class LocalizeServise {

    public String getCurrentTimeLabel(String language) {
        if ("uk".equals(language)){
            return "Поточній час";
        }
         if("ss".equals(language)){
            return "Nicht ferstain!";
        }
        return "Current time";
    }
}
