package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
  public void save(Category category);
  public Optional<Category> get(Long id);
  public List<Category> getAll();
  public List<Category> find(String name);
}
