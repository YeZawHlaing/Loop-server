package com.server.loop.repositories;
import com.server.loop.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByNameIgnoreCase(String name);
    Optional<Role> findByNameIgnoreCase(String name);
    
}
