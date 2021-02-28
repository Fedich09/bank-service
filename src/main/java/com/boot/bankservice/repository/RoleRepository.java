package com.boot.bankservice.repository;

import com.boot.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("from role r where r.roleName = :name")
    Optional<Role> getByRoleName(@Param("name") Role.RoleType name);
}
