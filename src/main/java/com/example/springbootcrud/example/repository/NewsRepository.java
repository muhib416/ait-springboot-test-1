package com.example.springbootcrud.example.repository;

import com.example.springbootcrud.example.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
