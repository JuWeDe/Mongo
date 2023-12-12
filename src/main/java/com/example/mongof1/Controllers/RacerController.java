package com.example.mongof1.Controllers;

import com.example.mongof1.Models.Racer;
import com.example.mongof1.Services.RacerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RacerController {
    private final RacerService racerService;

    public RacerController(RacerService racerService) {
        this.racerService = racerService;
    }

    @PostMapping("/racers")
    public Racer createRacer(@RequestBody Racer racer) {
        return racerService.saveRacer(racer);
    }

    @PutMapping("/racers/{id}")
    public Racer updateRacer(@PathVariable String id, @RequestBody Racer racer) {
        Racer existingRacer = racerService.getRacerById(id);
        if (existingRacer != null) {
            racer.setId(existingRacer.getId()); // Устанавливаем идентификатор из существующей записи
            return racerService.saveRacer(racer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/racers/{id}")
    public void deleteRacer(@PathVariable String id) {
        racerService.deleteRacer(id);
    }
}
