package com.goit12.testapp.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RequestMapping("/current-time") // основний виносимо сюди
@Controller// зазвичай контролер звертається до методів сервісу і інжектимо в нього
public class CurrentTimeController { // відкликається на методи гет запиту по такому то урл
    // тобто коли буде гет запит по такому то урл то виконається цей метод

    //  написали сервіс для конвертування часу додаємо поле і юзаємо в методі
    private final CurrentTimeServise currentTimeServise;

    //@RequestMapping(method = RequestMethod.GET, value = "/current-time")
    // @GetMapping("current-time")// більш коротший шлях

    @GetMapping("/get") // тут вже пишемо шлях відностно методу http://localhost:8090/current-time/get
    public ModelAndView getCurrentTime(@RequestParam(required = false, defaultValue = "UTC") String timezone) {
        // в конструктор передали назву html файлу з папки templates яку він по дефолту там шука
        ModelAndView result = new ModelAndView("current-time");
        // додаємо згідно шаблону time і його реалізацію
        result.addObject("time2", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        // значень може бути багато вони копляться + додав рендом
        result.addObject("random", Math.random() * 100);
        result.addObject("random2", (int) (Math.random() * 100));
        result.addObject("time", currentTimeServise.getCurrentTime(timezone));
        return result;

        // http://localhost:8080/current-time // іноді треба змінити порт на 8090 якщо
        // 8080 буде зайнятий в application.properties -> server.port = 8090
    }

    @PostMapping("/post-x-form-url-encoded")
    public ModelAndView postCurrentTimeXFormUrlEncoded(String tz) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeServise.getCurrentTime(tz));

        return result;
    }
    @PostMapping("/post-json")
    public ModelAndView getCurrentTimeJson(@RequestBody CurrentTimeRequest request) {
        // вважаємо що нам прихоить Json
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeServise.getCurrentTime(
                request.getTimezone(),request.getFormat()
        ));

        return result;

    }


}


// getCurrentTime(@RequestParam(required = false) String timezone)
// додали параметр на який буде реагувати запит, required = false встановлюємо
// якщо параметр запиту не обовязковий, без цього буде очікувати параметр
// defaultValue = "UTC" вказуємо параметр за замовчуванням якщо не введуть
// @RequestBody вказує візьми тіло запиту, і перетвори його в обьект