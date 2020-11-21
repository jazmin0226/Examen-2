package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopServiceImpl  implements WorkshopService{

  @Autowired
  WorkshopRepository repository;

  @Override
  public void save(Workshop workshop) { repository.save(workshop); }

  @Override
  public Optional<Workshop> get(Long id) { return repository.findById(id); }

  @Override
  public List<Workshop> getAll()  {
    return repository.findAll();
  }

  @Override
  public List<Workshop> find(String name) {
    return repository.findByNameContaining(name);
  }

  @Override
  public List<Workshop> findByFilterCategory(String filter) {
    return repository.findByFilterCategory(filter);
  }

  @Override
  public List<Workshop> findByFilterAuthor(String filter) {
    return repository.findByFilterAuthor(filter);
  }

  @Override
  public List<Workshop> findByFilterKeyword(String filter) {
    return repository.findByFilterKeywords(filter);
  }
}
