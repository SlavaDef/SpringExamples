package com.goit12.testapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RequestMapping("/file")
@Controller
public class FileController {

    @PostMapping("/upload")
    public ModelAndView postReceiveFile(@RequestParam(name = "file") MultipartFile multipartFile) throws IOException {

        ModelAndView resalt = new ModelAndView("upload-file");


        byte[] bytes = multipartFile.getBytes(); // повертаємо кількість байтів з файлу
        resalt.addObject("fileSize", bytes.length);
        resalt.addObject("fileContent", new String(bytes)); // return text from file



        return resalt;

    }

}
