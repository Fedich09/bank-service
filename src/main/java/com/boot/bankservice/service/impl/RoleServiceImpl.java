package com.boot.bankservice.service.impl;

import com.boot.bankservice.exception.DataProcessingException;
import com.boot.bankservice.model.Role;
import com.boot.bankservice.repository.RoleRepository;
import com.boot.bankservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getRoleByRoleName(Role.RoleType.valueOf(name))
                .orElseThrow(() -> new DataProcessingException("Can't get role by name " + name));
    }
}
