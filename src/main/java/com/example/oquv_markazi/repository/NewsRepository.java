package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<News, UUID> {
}
