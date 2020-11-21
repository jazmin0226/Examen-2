package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
  public void save(Activity activity);
  public Optional<Activity> get(Long id);
  public List<Activity> getAll();
  public List<Activity> find(String name);
}
