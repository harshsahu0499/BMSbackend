package fr.epita.bms.controller;

import fr.epita.bms.domain.Admin;
import fr.epita.bms.domain.Report;
import fr.epita.bms.domain.User;
import fr.epita.bms.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping("/reports/submitreports")
    public Report createReport(@RequestBody Report report){
        return reportRepository.save(report);
    }
    @GetMapping(path="/reports/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> searchByUserId(@PathVariable("userId") Integer userId){

        try {
            List<Report> reports = reportRepository.findByUserId(userId);
            return ResponseEntity.ok(reports);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path="/reports/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> GetAllReports(){

        try {
            List<Report> reports = reportRepository.findAll();
            return ResponseEntity.ok(reports);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
