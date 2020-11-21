package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Category;
import com.cenfotec.examen2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository repository;

  @Override
  public void save(Category category) {
    repository.save(category);
  }

  @Override
  public Optional<Category> get(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Category> find(String name) {
    return repository.findByNameContaining(name);
  }

  @Override
  public List<Category> getAll() {
    return repository.findAll();
  }
}
