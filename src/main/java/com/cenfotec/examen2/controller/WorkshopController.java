package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.domain.Activity;
import com.cenfotec.examen2.domain.Category;
import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.service.ActivityService;
import com.cenfotec.examen2.service.CategoryService;
import com.cenfotec.examen2.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class WorkshopController {

  @Autowired
  WorkshopService workshopService;

  @Autowired
  ActivityService activityService;

  @Autowired
  CategoryService categoryService;

  @RequestMapping("/")
  public String home(Model model){
    return "home";
  }

  @GetMapping("/retrieveByCategory")
  public String getByCategory(Model model, String filter) {
      if (filter != null){
        model.addAttribute("workshopsC", workshopService.findByFilterCategory(filter));
      }else{
        model.addAttribute("workshopsC", workshopService.getAll());
      }

    return "retrieveByCategory";
  }

  @GetMapping("/retrieveByAuthor")
  public String getByAuthor(Model model, String filter) {
    if (filter != null){
      model.addAttribute("workshopsA", workshopService.findByFilterAuthor(filter));
    }else{
      model.addAttribute("workshopsA", workshopService.getAll());
    }

    return "retrieveByAuthor";
  }

  @GetMapping("/retrieveByKeyword")
  public String getByKeyword(Model model, String filter) {
    if (filter != null){
      model.addAttribute("workshopsK", workshopService.findByFilterKeyword(filter));
    }else{
      model.addAttribute("workshopsK", workshopService.getAll());
    }

    return "retrieveByKeyword";
  }

  @RequestMapping(value = "/createWorkshop",  method = RequestMethod.GET)
  public String insertarPage(Model model) {
    model.addAttribute(new Workshop());

    List<Category> list = categoryService.getAll();
    model.addAttribute("category", list);

    return "createWorkshop";
  }

  @RequestMapping(value = "/createWorkshop",  method = RequestMethod.POST)
  public String createAction(Workshop workshop, BindingResult result, Model model) {
    workshopService.save(workshop);
    return "home";
  }

  @RequestMapping("/retrieveWorkshop")
  public String listar(Model model) {
    model.addAttribute("workshops",workshopService.getAll());
    return "retrieveWorkshop";
  }

  @RequestMapping("/updateWorkshop/{id}")
  public String findWorkshopToEdit(Model model, @PathVariable long id) {
    Optional<Workshop> possibleData = workshopService.get(id);
    if (possibleData.isPresent()) {
      model.addAttribute("workshopToUpdate",possibleData.get());
      List<Category> list = categoryService.getAll();
      model.addAttribute("category", list);
      return "updateWorkshop";
    }
    return "notfound";
  }

  @RequestMapping(value="/updateWorkshop/{id}",  method = RequestMethod.POST)
  public String saveEdition(Workshop workshop, Model model, @PathVariable long id) {
    workshopService.save(workshop);
    return "home";
  }

  @RequestMapping(value="/detailWorkshop/{id}")
  public String saveEdition(Model model, @PathVariable long id) {
    Optional<Workshop> possibleData = workshopService.get(id);
    if (possibleData.isPresent()) {
      model.addAttribute("workshopData",possibleData.get());
      return "detailWorkshop";
    }
    return "notfound";
  }



}
