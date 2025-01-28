package org.generation.jaita138.boh.demo5.db.repo;

import org.generation.jaita138.boh.demo5.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {

}
