package org.generation.jaita138.boh.demo5.db.service;

import java.util.List;

import org.generation.jaita138.boh.demo5.db.entity.Role;
import org.generation.jaita138.boh.demo5.db.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public void save(Role role) {
        roleRepo.save(role);
    }

    public Role findById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    public Role findByTitolo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTitolo'");
    }
}
