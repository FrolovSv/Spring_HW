package ru.HomeWork.Logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private final Map<Integer,Pet> model;

    public PetModel() {
        model = new HashMap<Integer,Pet>();

        model.put(1,new Pet("Тузик", "Собакен",2));
        model.put(2,new Pet("Мурзик", "Котэ",4));
        model.put(3,new Pet("Шарик-болбес", "утка",9));
    }

    public static PetModel getInstance(){
        return instance;
    }

    public boolean add(Pet pet, Integer id){
        try{
            model.put(id,pet);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Pet getFromList(Integer id){
        return model.get(id);
    }

    public Map<Integer,Pet> getAll(){
        return model;
    }

    public boolean deletPet(Integer id){
        boolean status = true;
        try {
            if (id > 0 && id <= model.size()) {
                model.remove(id);
            } else if (id == 0){
                model.clear();
            }else if (id<0)
                status = false;

        }catch (Exception e){
            System.out.println(e.getMessage());
            status = false;
        }
        return status;
    }

    public boolean editPet(Integer id,Pet pet){
        if(model.containsKey(id)) {
            model.put(id, pet);
            return true;
        }else
            return false;
    }

}
