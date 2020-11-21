package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Activity;
import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  ActivityRepository repository;

  @Override
  public void save(Activity activity) { repository.save(activity); }

  @Override
  public Optional<Activity> get(Long id) { return repository.findById(id); }

  @Override
  public List<Activity> getAll()  {
    return repository.findAll();
  }

  @Override
  public List<Activity> find(String name) {
    return repository.findByNameContaining(name);
  }
}
