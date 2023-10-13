package org.example.service;

import java.util.List;
import org.example.model.Grade;
import org.example.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Double calculateAverage() {
    logger.info("Sacando el promedio de notas");
    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    if (gradeList != null) {
      int cantidad = 0;
      Double sumaNotas = 0.0;
      for (Grade grade : gradeList) {
        sumaNotas += grade.grade();
        cantidad ++;
      }
      return sumaNotas / cantidad;
    }
    return null;
  }

  @Override
  public Integer sumNumberOfGrades() {
    logger.info("Sumando el número de calificaciones");
    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    // TODO sum number of grades and return the summation
    if (gradeList != null) {
      Double sumaNotas = 0.0;
      for (Grade grade : gradeList) {
        sumaNotas += grade.grade();
      }
      return sumaNotas.intValue();
    }
    return null;
  }
}
