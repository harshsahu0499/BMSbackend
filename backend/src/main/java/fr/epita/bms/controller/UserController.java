package fr.epita.bms.controller;

import fr.epita.bms.domain.User;
import fr.epita.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //Get All users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //POST user via rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
//        User updatedUser = userRepository.findById(id);
//        user.setFirstName(updatedUser.getFirstName());
//        user.setEmailAddress(updatedUser.getEmailAddress());
//        // update other fields as needed
//        return userRepository.save(user);
//    }

    @GetMapping(path="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> get(@PathVariable("id") String id){

        try {
            List<User> questionDTO = userRepository.findById(Integer.parseInt(id));
            return ResponseEntity.ok(questionDTO);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }



}
