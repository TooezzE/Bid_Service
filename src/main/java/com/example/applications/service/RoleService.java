package com.example.applications.service;

import com.example.applications.model.entity.Role;
import com.example.applications.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public Role getDefaultRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
