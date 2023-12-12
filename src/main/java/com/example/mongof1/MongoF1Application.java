package com.example.mongof1;

import com.example.mongof1.Services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoF1Application {
//    private final CarServiceImpl carService;
//    private final RacerServiceImpl racerService;
//    private final TeamServiceImpl teamService;
//
//    public MongoF1Application(CarServiceImpl carService, RacerServiceImpl racerService, TeamServiceImpl teamService) {
//        this.carService = carService;
//        this.racerService = racerService;
//        this.teamService = teamService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(MongoF1Application.class, args);
//        DatabaseSeederService databaseSeederService = new DatabaseSeederService();
//        databaseSeederService.seedDatabase();
    }

}
