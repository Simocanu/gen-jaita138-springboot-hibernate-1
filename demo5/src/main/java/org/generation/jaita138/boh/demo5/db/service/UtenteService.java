package org.generation.jaita138.boh.demo5.db.service;

import java.util.List;

import org.generation.jaita138.boh.demo5.db.entity.Utente;
import org.generation.jaita138.boh.demo5.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente utente) {
        utenteRepo.save(utente);
    }

    public void delete(Utente utente) {
        utenteRepo.delete(utente);
    }

    public List<Utente> findAll() {
        return utenteRepo.findAll();
    }

    public Utente findById(Long id) {
        return utenteRepo.findById(id).orElse(null);
    }

    public List<Utente> findByNomeStartingWith(String prefix) {
        return utenteRepo.findByNomeStartingWith(prefix);
    }

    public List<Utente> findByCreditoGreaterThan(int credito) {
        return utenteRepo.findByCreditoGreaterThan(credito);
    }

    public List<Utente> findByNomeOrCognomeIsNull() {
        return utenteRepo.findByNomeIsNullOrCognomeIsNull();
    }

    public List<Utente> findByCreditoBetween() {
        return utenteRepo.findByCreditoBetween(1, 1000);
    }
}