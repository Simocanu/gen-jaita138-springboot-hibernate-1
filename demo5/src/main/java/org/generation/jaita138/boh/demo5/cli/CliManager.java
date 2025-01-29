package org.generation.jaita138.boh.demo5.cli;

import java.util.List;
import java.util.Scanner;
import org.generation.jaita138.boh.demo5.db.entity.Utente;
import org.generation.jaita138.boh.demo5.db.entity.Role;
import org.generation.jaita138.boh.demo5.db.service.RoleService;
import org.generation.jaita138.boh.demo5.db.service.UtenteService;

public class CliManager {

    private Scanner sc;
    private UtenteService utenteService;
    private RoleService roleService;

    public CliManager(UtenteService utenteService, RoleService roleService) {
        sc = new Scanner(System.in);
        this.utenteService = utenteService;
        this.roleService = roleService;
        printOptions();
    }

    private void printOptions() {
        System.out.println("Operazioni:");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5. Trova utenti con nome che inizia con 'a'");
        System.out.println("6. Trova utenti con credito superiore a 10 euro");
        System.out.println("7. Trova utenti con credito positivo ma inferiore a 10 euro");
        System.out.println("8. Trova utenti con nome o cognome NULL");
        System.out.println("9. Esci");
        System.out.println("");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {
            case 1:
                readAll();
                break;
            case 2:
                insert();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                findByNomeStartingWithA();
                break;
            case 6:
                findByCreditoGreaterThan();
                break;
            case 7:
                findByCreditoBetween();
                break;
            case 8:
                findByNomeOrCognomeIsNull();
                break;
            case 9:
                return;
            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void readAll() {
        List<Utente> utenti = utenteService.findAll();
        System.out.println("Utenti:");
        System.out.println(utenti);
        System.out.println("-------------------------------------");
    }

    private void insert() {
        Utente u = new Utente();

        System.out.println("nome:");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome:");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username:");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password:");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito (in centesimi):");
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        System.out.println("Ruoli disponibili:");
        List<Role> roles = roleService.findAll();
        for (Role role : roles) {
            System.out.println(role.getId() + " - " + role.getTitolo());
        }

        System.out.println("Inserisci l'ID del ruolo:");
        Long roleId = Long.parseLong(sc.nextLine());
        Role selectedRole = roleService.findById(roleId);

        if (selectedRole != null) {
            u.setRole(selectedRole);
        } else {
            System.out.println("Ruolo non valido, impostato USER di default.");
            u.setRole(roleService.findByTitolo("USER"));
        }

        utenteService.save(u);
        System.out.println("Utente salvato con successo!");
    }

    private void edit() {
        System.out.println("edit id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u == null) {
            System.out.println("Utente non trovato");
            return;
        }

        System.out.println("nome: (" + u.getNome() + ")");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome: (" + u.getCognome() + ")");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username: (" + u.getUsername() + ")");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password: (" + u.getPassword() + ")");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito: (" + u.getCredito() + ")");
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        System.out.println("Ruolo attuale: " + u.getRole().getTitolo());
        System.out.println("Vuoi modificare il ruolo? (s/n)");
        String changeRole = sc.nextLine();

        if (changeRole.equalsIgnoreCase("s")) {
            System.out.println("Ruoli disponibili:");
            List<Role> roles = roleService.findAll();
            for (Role role : roles) {
                System.out.println(role.getId() + " - " + role.getTitolo());
            }

            System.out.println("Inserisci il nuovo ID del ruolo:");
            Long roleId = Long.parseLong(sc.nextLine());
            Role selectedRole = roleService.findById(roleId);

            if (selectedRole != null) {
                u.setRole(selectedRole);
            } else {
                System.out.println("Ruolo non valido, mantenuto quello attuale.");
            }
        }

        utenteService.save(u);
        System.out.println("Utente modificato con successo!");
    }

    private void delete() {
        System.out.println("delete id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u != null) {
            utenteService.delete(u);
            System.out.println("Utente " + strId + " eliminato");
        } else {
            System.out.println("Utente non trovato");
        }
    }

    private void findByNomeStartingWithA() {
        List<Utente> utenti = utenteService.findByNomeStartingWith("a");

        System.out.println("Utenti con nome che inizia con 'a':");
        for (Utente utente : utenti) {
            System.out.println(utente);
        }
        System.out.println("-------------------------------------");
    }

    private void findByCreditoGreaterThan() {
        List<Utente> utenti = utenteService.findByCreditoGreaterThan(1000);

        System.out.println("Utenti con credito superiore a 10 euro:");
        for (Utente utente : utenti) {
            System.out.println(utente);
        }
        System.out.println("-------------------------------------");
    }

    private void findByCreditoBetween() {
        List<Utente> utenti = utenteService.findByCreditoBetween();

        System.out.println("Utenti con credito positivo ma inferiore a 10 euro:");
        if (utenti.isEmpty()) {
            System.out.println("Nessun utente trovato con credito positivo ma inferiore a 10 euro.");
        } else {
            for (Utente utente : utenti) {
                System.out.println(utente);
            }
        }
        System.out.println("-------------------------------------");
    }

    private void findByNomeOrCognomeIsNull() {
        List<Utente> utenti = utenteService.findByNomeOrCognomeIsNull();

        System.out.println("Utenti con nome o cognome NULL:");
        if (utenti.isEmpty()) {
            System.out.println("Nessun utente trovato con nome o cognome NULL.");
        } else {
            for (Utente utente : utenti) {
                System.out.println(utente);
            }
        }
        System.out.println("-------------------------------------");
    }
}