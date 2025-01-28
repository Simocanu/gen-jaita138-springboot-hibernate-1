package org.generation.jaita138.boh.demo5.db.repo;

import org.generation.jaita138.boh.demo5.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {

    List<Utente> findByNomeStartingWith(String prefix);

    List<Utente> findByCreditoGreaterThan(int credito);

    List<Utente> findByNomeIsNullOrCognomeIsNull();

    List<Utente> findByCreditoBetween(int minCredito, int maxCredito);

}
