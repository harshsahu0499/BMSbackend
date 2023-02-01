package fr.epita.bms.controller;

import fr.epita.bms.domain.Admin;
import fr.epita.bms.domain.User;
import fr.epita.bms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    // Get All admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    // Post admin via rest api
    @PostMapping("/admins")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin){
        Admin updateAdmin = adminRepository.findById(id);
        updateAdmin.setFirstName(admin.getFirstName());
        updateAdmin.setLastName(admin.getLastName());
        updateAdmin.setBuildingNumber(admin.getBuildingNumber());
        updateAdmin.setEmailAddress(admin.getEmailAddress());
        updateAdmin.setPassword(admin.getPassword());
        updateAdmin.setPhoneNumber(admin.getPhoneNumber());
        return adminRepository.save(updateAdmin);
    }

    @GetMapping(path="/admins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> searchAdmin(@PathVariable("id") String id){

        try {
            Admin adminDTO = adminRepository.findById(Integer.parseInt(id));
            return ResponseEntity.ok(adminDTO);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path="/admins/email/{emailAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> searchAdminByEmail(@PathVariable("emailAddress") String emailAddress){

        try {
            Admin adminDTO = adminRepository.findByEmailAddress(emailAddress);
            return ResponseEntity.ok(adminDTO);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
