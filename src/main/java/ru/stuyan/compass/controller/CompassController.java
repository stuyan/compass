package ru.stuyan.compass.controller;

import org.springframework.web.bind.annotation.*;
import ru.stuyan.compass.logic.CompassModel;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/compass")
public class CompassController {

    private final CompassModel model = CompassModel.getInstance();

    @PostMapping(value = "/init", consumes = "application/json")
    public String init(@RequestBody Map<String, String> initialMap) {
        model.init(initialMap);
        return "Компас успешно проинициализирован";
    }

    @GetMapping(value = "/getSide",
            consumes = "application/json",
            produces = "application/json")
    public Map<String, String> getSide(@RequestBody Map<String, String> request) {
        Map<String, String> result = new HashMap<>();
        if (model.getAll().isEmpty()) {
            result.put("Error", "Компас не был проинициализирован");
        } else {
            String side = model.getSide(Double.valueOf(request.get("Degree")));
            if (side.isEmpty()) {
                result.put("Error", "Недопустимое значение!");
            } else {
                result.put("Side", side);
            }
        }
        return result;
    }

}
