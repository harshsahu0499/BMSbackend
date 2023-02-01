package fr.epita.bms.repository;

import fr.epita.bms.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository  extends JpaRepository<Report, Long> {
}
