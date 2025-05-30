package com.gammatech.sneakers.service;

import com.gammatech.sneakers.entity.Sneaker;
import com.gammatech.sneakers.repository.SneakersRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class SneakersService {

    private final SneakersRepository sneakersRepository;

    public SneakersService(SneakersRepository sneakersRepository) {
        this.sneakersRepository = sneakersRepository;
    }

    public Sneaker save(Sneaker sneaker) {
        if (sneaker.getName() == null ||
                sneaker.getBrand() == null || sneaker.getColor() == null ||
                sneaker.getSize() == null || sneaker.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid sneaker data");
        }

        return sneakersRepository.save(sneaker);
    }

    public Sneaker delete(Long sneakerId) {
        Optional<Sneaker> sneakerToDelete = this.getById(sneakerId);
        if (sneakerToDelete.isEmpty()) {
            throw new EmptyStackException();
        }

        sneakersRepository.deleteById(sneakerToDelete.get().getId());
        return sneakerToDelete.get();
    }

    private Optional<Sneaker> getById(Long sneakerId) {
        return sneakersRepository.findById(sneakerId);
    }

    public List<Sneaker> getAll() {
        return (List<Sneaker>) sneakersRepository.findAll();
    }
}
