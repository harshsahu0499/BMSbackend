package fr.epita.bms.repository;

import fr.epita.bms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByEmailAddress(String emailAddress);
}
