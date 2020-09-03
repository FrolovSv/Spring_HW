package ru.HomeWork.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.HomeWork.Logic.CompassModel;

import java.util.Map;

/*
Вторая часть ДЗ:
Создать REST веб-сервис (компас) используя технологию Spring, который будет определять сторону света по введенным градусам (от 0 до 359). Точка отсчета будет север - 0 градусов.
Изначально нужно дать понять сервису с помощью POST-запроса какие диапазоны градусов будут отвечать за какие стороны света. В примере ниже рассмотрены 4 диапазона (север, юг, запад, восток), а в ДЗ необходимо создать 8 (северо-восток, юго-запад и тд). Реализация свободная, например, можно записать в Map - в качестве ключа будут стороны света, а значение - это диапазон градусов, но при этом поддерживается любой энтузиазм :)
Пример запроса:

{
    "Nortn": "316-45",
    "East":  "46-135",
    "South": "136-225",
    "West": "226-315"
}
В качестве GET-запроса необходимо реализовать вывод стороны света по запрашиваемому градусу, например:
Запрос:
{
    "Degree": 56
}
Ответ:
{
    "Side": "East"
}
*/

@RestController
public class CompassController {
    private static final CompassModel compassModel = CompassModel.getInstance();

    //обрабатывем PUT запрос
    @PutMapping(value = "/setCompass",consumes = "application/json",produces = "text/html")
    public String setCompass(@RequestBody Map<String,String> compass){
        //Проверяем полученное значение из вызова метода на добавелние диапазонов в компас и запроса клиента
        if(compassModel.addAllParam(compass))
            return "<html>" +
                    "<h3>Поздравляю, вы успешно добавили диапазоны градусов для компаса</h3>" +
                    "</html>";
        else
            return "<html>" +
                    "<h3> Что-то пошло не так</h3>" +
                    "</html>";
    }

    //Обрабатываем запрос GET
    @GetMapping(value = "/getSideCompass",consumes = "application/json",produces = "application/json")
    public Map<String,String> getSideCompass(@RequestBody Map<String,Integer> dot){
        //Обрабатывем запрос клиента и выдаем ответ
        return compassModel.getSide(dot.get("Degree"));
    }
}
