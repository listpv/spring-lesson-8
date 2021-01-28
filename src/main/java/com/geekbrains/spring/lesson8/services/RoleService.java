package com.geekbrains.spring.lesson8.services;

import com.geekbrains.spring.lesson8.entities.Role;
import com.geekbrains.spring.lesson8.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }
}
