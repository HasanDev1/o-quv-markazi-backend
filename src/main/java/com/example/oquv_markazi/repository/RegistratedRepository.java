package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.Registrated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegistratedRepository extends JpaRepository<Registrated, UUID> {
    Page<Registrated> findAll(Pageable pageable);
}
