package com.cenfotec.examen2.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @OneToMany(fetch=FetchType.LAZY, mappedBy="category")
  private Set<Workshop> workshop;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Workshop> getWorkshop() {
    return workshop;
  }

  public void setWorkshop(Set<Workshop> workshop) {
    this.workshop = workshop;
  }
}
