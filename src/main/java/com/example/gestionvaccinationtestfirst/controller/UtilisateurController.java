package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.service.UserService.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur")
@AllArgsConstructor
@CrossOrigin("*")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    @GetMapping("/users")
    public List<UtilisateurDTO> getAllUsers(){
        return utilisateurService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UtilisateurDTO getUserById(@PathVariable long userId) throws UtilisateurNotFoundException {
        return utilisateurService.getUserBYId(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        utilisateurService.deleteUser(userId);
    }

    @PutMapping("/users/{userId}")
    public UtilisateurDTO updateUser(@RequestBody UtilisateurDTO utilisateurDTO,@PathVariable Long userId){
        utilisateurDTO.setId(userId);
        return utilisateurService.updateUser(utilisateurDTO);
    }

    @PostMapping("/users/{centreId}")
    public UtilisateurDTO saveUser(@RequestBody UtilisateurDTO utilisateurDTO,@PathVariable Long centreId) throws CentreNotFoundException {
        return utilisateurService.saveUser(utilisateurDTO,centreId);
    }
}
