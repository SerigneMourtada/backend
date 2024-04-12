package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.service.EnfantService.EnfantServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Enfant")
@AllArgsConstructor
@CrossOrigin("*")
public class EnfantController {
    private EnfantServ enfantServ;
    @PostMapping("/enfants")
    public EnfantDTO saveChild(@RequestBody EnfantDTO enfantDTO,
                               @RequestParam(name="nom") String nom,
                               @RequestParam(name="prenom") String prenom,
                               @RequestParam(name ="telephone") String telephone,
                               @RequestParam(name="adresse") String adresse,
                               @RequestParam(name = "lien") String lien){
        return enfantServ.saveEnfant(enfantDTO,nom,prenom,telephone,adresse,lien);
    }

    @GetMapping("/enfants")
    public List<EnfantDTO> getAllEnfants(){
        return enfantServ.getAllEnfants();
    }
    @GetMapping("/enfants/{enfantId}")
    public EnfantDTO getEnfantById(@PathVariable(name = "enfantId") Long enfantId) throws EnfantNotFoundException {
        return enfantServ.getEnfantById(enfantId);
    }

    @DeleteMapping("/enfants/{enfantId}")
    public void deleteEnfant(@PathVariable(name="enfantId") Long enfantId){
        enfantServ.deleteEnfant(enfantId);
    }

    @PutMapping("/enfants/{enfantId}")
    public EnfantDTO updateEnfant(@RequestBody EnfantDTO enfantDTO,
                                  @PathVariable(name = "enfantId") Long enfantId){
        enfantDTO.setId(enfantId);
        return enfantServ.updateEnfant(enfantDTO);
    }

    @PostMapping("/enfants/{parentId}")
    public EnfantDTO saveEnfant(@RequestBody EnfantDTO enfantDTO,@PathVariable(name = "parentId") Long parentId) throws ParentNotFoundException {
        return enfantServ.saveEnfant(enfantDTO,parentId);
    }
}
