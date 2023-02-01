package fr.epita.bms.controller;

import fr.epita.bms.domain.Report;
import fr.epita.bms.domain.User;
import fr.epita.bms.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping("/submitreports")
    public Report createReport(@RequestBody Report report){
        return reportRepository.save(report);
    }

}
