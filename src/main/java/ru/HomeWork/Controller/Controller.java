package ru.HomeWork.Controller;

import org.springframework.web.bind.annotation.*;
import ru.HomeWork.Logic.Pet;
import ru.HomeWork.Logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
Практическое задание №2
Выполненные задания залить в гит, и отправить ссылку преподавателю
Первая часть ДЗ (дополнение к видео):
Дополнить метод createPet() таким образом, чтобы в ответ на запрос возвращался текст об успешном создании питомца;
Реализовать удаление и изменение питомцев используя аннотации @DeleteMapping и @PutMapping соответственно.
*/

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static AtomicInteger newId = new AtomicInteger(1);

//    @PostMapping(value = "/createPet",consumes = "application/json")
//    public void createPet(@RequestBody Pet pet){
//        petModel.add(pet,newId.getAndIncrement());
//    }

    @PostMapping(value = "/createPet",consumes = "application/json",produces = "text/html")
    public String createPet(@RequestBody Pet pet){

        if (petModel.add(pet,newId.getAndIncrement())){
            if (petModel.getAll().size()==1)
                return "<html>" +
                    "<h3> Поздравляем, вы создали своего ПЕРВОГО питомца!</h3>" +
                    "Он это - "+ pet.getType() + ", его зовут " + pet.getName() + " и ему/ей " + pet.getAge() + " год/года/лет" +
                    "</html>";
            else
                return "<html>" +
                        "<h3> Поздравляем, вы создали очередного питомца!</h3>" +
                        "Он это - "+ pet.getType() + ", его зовут " + pet.getName() + " и ему/ей " + pet.getAge() + " год/года/лет" +
                        "</html>";
        }else {
            return "<html>" +
                    "<h3> Что-то пошло не так</h3>" +
                    "</html>";
        }

    }

    @GetMapping(value = "/getAllPets",produces = "application/json")
    public Map<Integer,Pet> getAllPets(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet",consumes = "application/json",produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id){
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet",consumes = "application/json",produces = "text/htmln")
    public String deletePet(@RequestBody Map<String, Integer> id){
        if (petModel.deletPet(id.get("id")))
            if (id.get("id")==0)
                return "<html>" +
                        "<h3> Вы успешно удалилил ВСЕХ питомцев из базы</h3>" +
                        "Осталось "+ petModel.getAll().size() + " питомцев (((( Изверг!" +
                        "</html>";
            else
                return "<html>" +
                        "<h3> Вы успешно удалилил питомца по ID = "+id.get("id")+" из базы</h3>" +
                        "Оатслось всего "+ petModel.getAll().size() + " питомцев/питомца, ОСТАНАВИСЬ!" +
                        "</html>";
        else
            return "<html>" +
                    "<h3> Что-то пошло не так</h3>" +
                    "</html>";
    }

    @PutMapping(value = "/editPet",consumes = "application/json",produces = "text/htmln")
    public String editPet(@RequestBody Map<String,String> pet){
        Integer id = Integer.parseInt(pet.get("id"));
        String name = pet.get("name");
        String type = pet.get("type");
        Integer age = Integer.parseInt(pet.get("age"));
        if (petModel.editPet(id,new Pet(name,type,age)))
            return "<html>" +
                    "<h3>Вы успешно внесли изменения питомцу по ID = "+id+"</h3>" +
                    "Новое имя - "+name+"<br/>"+
                    "Новый тип - "+type+"<br/>"+
                    "Новый возраст - "+age+"<br/>"+
                    "</html>";
        else
            return "<html>" +
                    "<h3> Что-то пошло не так</h3>" +
                    "</html>";
    }
}
