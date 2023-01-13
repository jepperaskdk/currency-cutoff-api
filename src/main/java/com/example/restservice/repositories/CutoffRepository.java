package com.example.restservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restservice.models.Cutoff;

public interface CutoffRepository extends CrudRepository<Cutoff, Integer> {
    Cutoff findByIso(String iso);
}