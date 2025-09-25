package com.igor.backend.controller;

import com.igor.backend.dto.UserDTO;
import com.igor.backend.model.User;
import com.igor.backend.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;




    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @Transactional
    public User cadastrar(@Valid @RequestBody UserDTO userDTO){

       String senhaCriptografada = passwordEncoder.encode(userDTO.senha());
        User user= new User(userDTO);
        user.setSenha(senhaCriptografada );


        return repository.save(user);


    }
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public List<UserDTO > listarUsuarios(){
        return repository.findAll().stream()
                .map(user-> new UserDTO(

                user.getId(),
                user.getNome(),
                user.getEmail(),
                null


                )).toList();
    }


    



}
