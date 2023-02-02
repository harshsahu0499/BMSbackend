package fr.epita.bms.repository;

import fr.epita.bms.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository  extends JpaRepository<Report, Long> {

    List<Report> findByUserId(Integer userId);
}
