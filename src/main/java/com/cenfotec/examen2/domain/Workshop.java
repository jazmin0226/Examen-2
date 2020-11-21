package com.cenfotec.examen2.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Workshop {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String author;
  private String objective;

  private String keyword1;
  private String keyword2;
  private String keyword3;
  private LocalTime totalTime = LocalTime.of(0,0);

  @ManyToOne
  @JoinColumn(name="cart_id", nullable=false)
  private Category category;

  @OneToMany(fetch=FetchType.LAZY, mappedBy="workshop")
  private Set<Activity> activities;

  public Workshop() {
  }

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String autor) {
    this.author = autor;
  }

  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getKeyword1() {
    return keyword1;
  }

  public void setKeyword1(String keyword1) {
    this.keyword1 = keyword1;
  }

  public String getKeyword2() {
    return keyword2;
  }

  public void setKeyword2(String keyword2) {
    this.keyword2 = keyword2;
  }

  public String getKeyword3() {
    return keyword3;
  }

  public void setKeyword3(String keyword3) {
    this.keyword3 = keyword3;
  }

  public Set<Activity> getActivities() {
    return activities;
  }

  public void setActivities(Set<Activity> activities) {
    this.activities = activities;
  }

  public LocalTime getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(LocalTime totalTime) {
    this.totalTime = totalTime;
  }


}
