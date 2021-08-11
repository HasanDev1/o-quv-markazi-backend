package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, UUID> {
}
