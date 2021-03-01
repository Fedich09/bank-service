package com.boot.bankservice.repository;

import com.boot.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> getRoleByRoleName(Role.RoleType name);
}
