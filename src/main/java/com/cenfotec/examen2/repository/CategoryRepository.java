package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  public List<Category> findByNameContaining(String word);
}
