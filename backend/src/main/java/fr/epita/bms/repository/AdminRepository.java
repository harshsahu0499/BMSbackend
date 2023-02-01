package fr.epita.bms.repository;

import fr.epita.bms.domain.Admin;
import fr.epita.bms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findById(long id);

    Admin findByEmailAddress(String emailAddress);
}
