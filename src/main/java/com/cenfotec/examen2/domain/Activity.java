package com.cenfotec.examen2.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String description;
  private String annexed;
  private LocalTime time;

  @ManyToOne
  @JoinColumn(name="cart_id", nullable=false)
  private Workshop workshop;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAnnexed() {
    return annexed;
  }

  public void setAnnexed(String annexed) {
    this.annexed = annexed;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public Workshop getWorkshop() {
    return workshop;
  }

  public void setWorkshop(Workshop workshop) {
    this.workshop = workshop;
  }

  @Override
  public String toString() {
    return "Actividad: " +
            "Nombre: " + name + '\n' +
            "Descripción: " + description + '\n' +
            "Notas: " + annexed + '\n' +
            "Duración: " + time;
  }
}
