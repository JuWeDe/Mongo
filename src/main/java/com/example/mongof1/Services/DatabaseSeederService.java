package com.example.mongof1.Services;

import com.example.mongof1.Models.Car;
import com.example.mongof1.Models.Racer;
import com.example.mongof1.Models.Team;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class DatabaseSeederService {
    private final CarService carService;
    private final RacerService racerService;
    private final TeamService teamService;
    private final Faker faker = new Faker();

    public DatabaseSeederService(CarService carService, RacerService racerService, TeamService teamService) {
        this.carService = carService;
        this.racerService = racerService;
        this.teamService = teamService;
    }
    public void seedDatabase() {
        seedCars();
        seedRacers();
        seedTeams();
    }

    private void seedCars() {
        for (int i = 0; i < 10000; i++) {
            Car car = new Car();
            car.setName(faker.name().fullName());
            car.setEngine(faker.regexify("([A-Z]){4}([A-Z]){2}([0-9A-Z]){2}([0-9A-Z]{3})?"));
            car.setHp(faker.number().numberBetween(100, 500));

            car.setCarNumber(faker.number().numberBetween(1, 100));

            carService.saveCar(car);
        }
    }

    private void seedRacers() {
        for (int i = 0; i < 10000; i++) {
            Racer racer = new Racer();
            racer.setName(faker.name().fullName());
            racer.setDateOfBirth(faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            racer.setWins(faker.number().numberBetween(0, 100));
            racer.setChampionships(faker.number().numberBetween(0, 10));
            racer.setPoints((float) faker.number().randomDouble(1,0,600));

            String carId = faker.regexify("[a-z1-9]{24}"); // генерируем случайный идентификатор для привязки к автомобилю
            Car car = carService.getCarById(carId);
            racer.setCar(car);

            racerService.saveRacer(racer);
        }
    }

    private void seedTeams() {
        for (int i = 0; i < 10000; i++) {
            Team team = new Team();
            team.setName(faker.team().name());
            team.setPoints((float) faker.number().randomDouble(1,0,1000));

            team.setTeamPrinciple(faker.name().fullName());

            teamService.saveTeam(team);
        }
    }
}
