package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Workshop;

import java.util.List;
import java.util.Optional;

public interface WorkshopService {
  public void save(Workshop workshop);
  public Optional<Workshop> get(Long id);
  public List<Workshop> getAll();
  public List<Workshop> find(String name);
  public List<Workshop> findByFilterCategory(String filter);
  public List<Workshop> findByFilterAuthor(String filter);
  public List<Workshop> findByFilterKeyword(String filter);
}
