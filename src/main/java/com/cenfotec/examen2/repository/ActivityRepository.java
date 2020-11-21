package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
  public List<Activity> findByNameContaining(String word);
}
