package org.generation.jaita138.boh.demo5.db.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String titolo;

    @Column(length = 128)
    private String descrizione;

    @OneToMany(mappedBy = "role")
    private List<Utente> utenti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    @Override
    public String toString() {
        return "Role [\n"
                + "  id=" + id + ",\n"
                + "  titolo=" + titolo + ",\n"
                + "  descrizione=" + descrizione + "\n"
                + "]";
    }
}
