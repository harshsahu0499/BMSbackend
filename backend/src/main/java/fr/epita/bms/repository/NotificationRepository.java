package fr.epita.bms.repository;

import fr.epita.bms.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAdminId(Integer adminId);
}
