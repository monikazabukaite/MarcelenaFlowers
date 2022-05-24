package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.UserRole;
import com.prekes.web.prekesweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role findById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role add(Role role) {
        return roleRepository.save(role);
    }

    public void update(Role role) {
        roleRepository.save(role);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }

    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    public Optional<Role> findByName(UserRole user) {
        return roleRepository.findByName(user);
    }
}
