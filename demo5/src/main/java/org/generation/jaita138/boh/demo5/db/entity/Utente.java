package org.generation.jaita138.boh.demo5.db.entity;

import jakarta.persistence.*;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String nome;

    @Column(length = 64, nullable = false)
    private String cognome;

    @Column(length = 128, unique = true, nullable = false)
    private String username;

    @Column(length = 64, nullable = false)
    private String password;

    private int credito;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utente [\n"
                + "  id=" + id + ",\n"
                + "  nome=" + nome + ",\n"
                + "  cognome=" + cognome + ",\n"
                + "  username=" + username + ",\n"
                + "  password=" + password + ",\n"
                + "  credito=" + credito + ",\n"
                + "  role=" + (role != null ? role.getTitolo() : "Nessun ruolo") + "\n"
                + "]";
    }
}
