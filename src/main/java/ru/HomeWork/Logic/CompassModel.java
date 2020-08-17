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

    public boolean addAllParam(Map<String,String> param){
        try {
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

    public HashMap<String,String> getSide(Integer dot){
        try {
            HashMap<String,String> response = new HashMap<String, String>();
            for (Map.Entry<String, String> entry : compass.entrySet()){
                Integer dig1 = Integer.parseInt(entry.getValue().split("-")[0]);
                Integer dig2 = Integer.parseInt(entry.getValue().split("-")[1]);
                if (dot>=dig1 && dot <= dig2)
                    response.put("Side",entry.getKey());
            }
            return response;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
