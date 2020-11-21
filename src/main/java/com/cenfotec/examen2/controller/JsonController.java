package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datatable")
public class JsonController {
  @Autowired
  WorkshopService workshopService;

  @GetMapping()
  public List<Workshop> getWorkshops(Model model){
    return workshopService.getAll();

  }
}
