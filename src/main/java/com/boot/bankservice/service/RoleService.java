package com.boot.bankservice.service;

import com.boot.bankservice.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
