package fr.epita.bms.controller;

import fr.epita.bms.domain.Notification;
import fr.epita.bms.domain.Report;
import fr.epita.bms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/notifications/createnotification")
    public Notification createNotification(@RequestBody Notification notification){
        return notificationRepository.save(notification);
    }
    @GetMapping(path="/notifications/{adminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> searchByAdminId(@PathVariable("adminId") Integer adminId){

        try {
            List<Notification> notifications = notificationRepository.findByAdminId(adminId);
            return ResponseEntity.ok(notifications);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path="/notifications/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> GetAllNotifications(){

        try {
            List<Notification> notifications = notificationRepository.findAll();
            return ResponseEntity.ok(notifications);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
