package com.igor.backend.service;

import com.igor.backend.model.User;
import com.igor.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

     @Autowired
     private BCryptPasswordEncoder passwordEncoder;

     @Autowired
     private  UserRepository repository;


     public User saveuser(User user ){





          return repository.save(user);
     };

     public List<User> listarUsuarios(){
          return repository.findAll();

     }

     public void salvarUser(User user){
          String rawPassword= user.getSenha();
          String hashedPassword= passwordEncoder.encode(rawPassword);
          user.setSenha(hashedPassword);

          repository.save(user);
     }



}
