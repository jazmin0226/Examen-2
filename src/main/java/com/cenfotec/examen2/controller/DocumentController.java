package com.cenfotec.examen2.controller;


import com.cenfotec.examen2.domain.Activity;
import com.cenfotec.examen2.domain.Workshop;
import com.cenfotec.examen2.service.WorkshopService;
import org.apache.poi.xwpf.usermodel.*;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;



@RestController
@RequestMapping("/report/{id}")
public class DocumentController {
  @Autowired
  WorkshopService workshopService;

  @GetMapping()
  public void getGenerateDocument(HttpServletResponse response, @PathVariable long id) throws IOException {
    response.setHeader("Content-disposition", "attachment; filename=test.docx");

    Optional<Workshop> workshopData = workshopService.get(id);
    if ( workshopData.isPresent() ) {
      Workshop workshop = workshopData.get();

      XWPFDocument document = new XWPFDocument();
      XWPFParagraph title = document.createParagraph();
      title.setAlignment(ParagraphAlignment.RIGHT);

      XWPFRun titleRun = title.createRun();
      titleRun.setText("Duración: " + workshop.getTotalTime());
      titleRun.setColor("0000");
      titleRun.setBold(true);
      titleRun.setFontFamily("Arial");
      titleRun.setFontSize(15);


      XWPFParagraph subTitle = document.createParagraph();
      subTitle.setAlignment(ParagraphAlignment.LEFT);

      XWPFRun subTitleRun = subTitle.createRun();
      subTitleRun.setText("Workshop: " + "\n" + "Nombre: " + workshop.getName() + "\n" + "Autor: " + workshop.getAuthor() + "\n" + "Objetivo: " + workshop.getObjective() +
              "\n" + "Categoría: " + workshop.getCategory().getName() + "\n" +
              "Palabras clave: " + workshop.getKeyword1() + ", " + workshop.getKeyword2() + ", " + workshop.getKeyword3() +
              "\n" + "Actividades: " + workshop.getActivities().toString());

      subTitleRun.setFontFamily("Arial");
      subTitleRun.setFontSize(12);
      subTitleRun.setTextPosition(20);



      document.write(response.getOutputStream());
    }
  }
}
