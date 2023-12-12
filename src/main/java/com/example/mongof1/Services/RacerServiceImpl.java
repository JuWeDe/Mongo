package com.example.mongof1.Services;

import com.example.mongof1.Models.Racer;
import com.example.mongof1.Repositories.RacerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacerServiceImpl implements RacerService {
    private final RacerRepository racerRepository;

    public RacerServiceImpl(RacerRepository racerRepository) {
        this.racerRepository = racerRepository;
    }

    @Override
    public List<Racer> getAllRacers() {
        return racerRepository.findAll();
    }

    @Override
    public Racer getRacerById(String id) {
        return racerRepository.findById(id).orElse(null);
    }

    @Override
    public Racer saveRacer(Racer racer) {
        return racerRepository.save(racer);
    }

    @Override
    public void deleteRacer(String id) {
        racerRepository.deleteById(id);
    }
}
