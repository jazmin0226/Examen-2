package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
  public List<Workshop> findByNameContaining(String word);

  @Query(value = "SELECT workshop.cart_id, Workshop.author, Workshop.keyword1, Workshop.keyword2, Workshop.keyword3, Workshop.name, Workshop.objective, Workshop.total_time,category.name, category.id FROM workshop " +
          "INNER JOIN Category on workshop.cart_id = category.id where category.name = :filter",
          nativeQuery = true)
  List<Workshop>findByFilterCategory(@Param("filter") String filter);

  @Query(value = "SELECT * FROM workshop where author = :filter", nativeQuery = true)
  List<Workshop>findByFilterAuthor(@Param("filter") String filter);

  @Query(value = "SELECT * FROM workshop where keyword1 = :filter  or  keyword2  = :filter or keyword3 = :filter", nativeQuery = true)
  List<Workshop>findByFilterKeywords(@Param("filter") String filter);
}
