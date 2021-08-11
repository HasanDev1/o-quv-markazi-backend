package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByRoleName(String rolName);
}
