package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
