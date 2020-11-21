package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.domain.Category;
import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.service.CategoryService;
import com.cenfotec.examen2.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class CategoryController {
  @Autowired
  CategoryService categoryService;

  @Autowired
  WorkshopService workshopService;

  @RequestMapping(value = "/createCategory",  method = RequestMethod.GET)
  public String insertarPage(Model model) {
    model.addAttribute(new Category());
    return "createCategory";
  }

  @RequestMapping(value = "/createCategory",  method = RequestMethod.POST)
  public String insertarAction(Category category, BindingResult result, Model model) {
    categoryService.save(category);
    return "home";
  }

  @RequestMapping("/retrieveCategory")
  public String listar(Model model) {
    model.addAttribute("categories",categoryService.getAll());
    return "retrieveCategory";
  }

  @RequestMapping("/updateCategory/{id}")
  public String findCategoryToUpdate(Model model, @PathVariable long id) {
    Optional<Category> possibleData = categoryService.get(id);
    if (possibleData.isPresent()) {
      model.addAttribute("categoryToUpdate",possibleData.get());
      return "updateCategory";
    }
    return "notfound";
  }

  @RequestMapping(value="/updateCategory/{id}",  method = RequestMethod.POST)
  public String saveEdition(Category category, Model model, @PathVariable long id) {
    categoryService.save(category);
    return "home";
  }

  @RequestMapping(value="/createWorkshop/{id}")
  public String recoverForAddArticle(Model model, @PathVariable long id) {
    Optional<Category> category = categoryService.get(id);
    Workshop newWorkshop= new Workshop();
    if (category.isPresent()) {
      newWorkshop.setCategory(category.get());
      model.addAttribute("category",category.get());
      model.addAttribute("workshop",newWorkshop);
      return "createWorkshop";
    }
    return "notfound";
  }

  @RequestMapping(value="/createWorkshop/{id}", method = RequestMethod.POST)
  public String saveArticle(Workshop workshop, Model model, @PathVariable long id) {
    Optional<Category> category = categoryService.get(id);
    if (category.isPresent()) {
      workshop.setCategory(category.get());
      workshopService.save(workshop);
      return "home";
    }
    return "errorArticle";
  }
}
