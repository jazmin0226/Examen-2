package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.domain.Activity;
import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.service.ActivityService;
import com.cenfotec.examen2.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;
import java.util.Optional;

@Controller
public class ActivityController {
  @Autowired
  ActivityService activityService;

  @Autowired
  WorkshopService workshopService;

  @RequestMapping(value="/AddActivity/{id}")
  public String recoverForAddActivity(Model model, @PathVariable long id) {
    Optional<Workshop> workshop = workshopService.get(id);
    Activity newActivity = new Activity();
    if (workshop.isPresent()) {
      newActivity.setWorkshop(workshop.get());
      model.addAttribute("workshop",workshop.get());
      model.addAttribute("activity",newActivity);
      return "AddActivity";
    }
    return "notfound";
  }

  @RequestMapping(value="/AddActivity/{id}", method = RequestMethod.POST)
  public String saveActivity(Activity activity, Model model, @PathVariable long id) {
    Optional<Workshop> workshop = workshopService.get(id);
    if (workshop.isPresent()) {
      Workshop wk = workshop.get();
      LocalTime totalDuration = addDuration(wk.getTotalTime(), activity.getTime());

      wk.setTotalTime(totalDuration);

      workshopService.save(wk);
      activity.setWorkshop(wk);
      activityService.save(activity);
      return "home";
    }
    return "errorActivity";
  }


  private LocalTime addDuration(LocalTime actualTime, LocalTime newTime){
      Integer actualHour = actualTime.getHour();
      Integer actualMinute = actualTime.getMinute();
      Integer newHour = newTime.getHour();
      Integer newMinute = newTime.getMinute();

      int totalHour = actualHour += newHour;
      int totalMinute = actualMinute += newMinute;

      LocalTime totalTime =  LocalTime.of(totalHour, totalMinute);
      return totalTime;
  }
}
