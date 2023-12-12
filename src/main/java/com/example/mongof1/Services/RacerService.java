package com.example.mongof1.Services;

import com.example.mongof1.Models.Racer;

import java.util.List;

public interface RacerService {
    List<Racer> getAllRacers();
    Racer getRacerById(String id);
    Racer saveRacer(Racer racer);
    void deleteRacer(String id);
}