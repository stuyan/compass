package ru.stuyan.compass.logic;

import java.util.HashMap;
import java.util.Map;

public class CompassModel {

    private static CompassModel INSTANCE = new CompassModel();

    private Map<String, Range> compass;

    public static CompassModel getInstance() {
        return INSTANCE;
    }

    private CompassModel() {
        compass = new HashMap<>();
    }

    public Map<String, Range> getAll() {
        return compass;
    }

    public void init(Map<String, String> initialMap) {
        for (Map.Entry<String, String> entry : initialMap.entrySet()) {
            compass.put(entry.getKey(), new Range(entry.getValue()));
        }
    }

    public String getSide(Double degree) {
        for (Map.Entry<String, Range> entry : compass.entrySet()) {
            if (entry.getValue().in(degree)) {
                return entry.getKey();
            }
        }
        return "";
    }

}
