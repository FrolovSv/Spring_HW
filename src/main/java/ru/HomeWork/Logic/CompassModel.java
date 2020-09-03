package ru.HomeWork.Logic;

import java.util.HashMap;
import java.util.Map;

public class CompassModel {
    private static final CompassModel instance = new CompassModel();

    private static final String North = "North";
    private static final String NorthEast = "NorthEast";
    private static final String East = "East";
    private static final String SouthEast = "SouthEast";
    private static final String South = "South";
    private static final String SouthWest = "SouthWest";
    private static final String West = "West";
    private static final String NorthWest = "NorthWest";

    private final Map<String,String> compass;

    public static CompassModel getInstance() {
        return instance;
    }

    public CompassModel() {
        //инициализируем МАП и добавлеяем в него значения сторон
        compass = new HashMap<String, String>();
        compass.put(North,"");
        compass.put(NorthEast,"");
        compass.put(East,"");
        compass.put(SouthEast,"");
        compass.put(South,"");
        compass.put(SouthWest,"");
        compass.put(West,"");
        compass.put(NorthWest,"");
    }

    //метод установки диапазонов значений в МАПу
    public boolean addAllParam(Map<String,String> param){
        try {
            //Заполняем занчения в МАП полученными из запроса клиента
            compass.put(North,param.get("North"));
            compass.put(NorthEast,param.get("NorthEast"));
            compass.put(East,param.get("East"));
            compass.put(SouthEast,param.get("SouthEast"));
            compass.put(South,param.get("South"));
            compass.put(SouthWest,param.get("SouthWest"));
            compass.put(West,param.get("West"));
            compass.put(NorthWest,param.get("NorthWest"));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Метод получения стороны света по координате
    public HashMap<String,String> getSide(Integer dot){
        //проверяем параметр на вхождение в диапазон
        if (dot>=0 && dot <= 360)
            try {
                HashMap<String,String> response = new HashMap<String, String>();
                //проходим по всем данным в МАПе
                for (Map.Entry<String, String> entry : compass.entrySet()){
                    //разбиваем строку на 2а числа от и до
                    Integer dig1 = Integer.parseInt(entry.getValue().split("-")[0]);
                    Integer dig2 = Integer.parseInt(entry.getValue().split("-")[1]);
                    //если искомая dot находтися внутри диапазона, то мы нашли верный и выдаем ответ
                    if (dot>=dig1 && dot <= dig2)
                        response.put("Side",entry.getKey());
                }
                return response;
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        else
            return null;

    }
}
