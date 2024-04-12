package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.service.CentreVaccinationService.CentreVaccServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CentreVaccination")
@AllArgsConstructor
@CrossOrigin("*")
public class CentreController {
    private CentreVaccServ centreVaccServ;

    @GetMapping("/centres")
    public List<CentreVaccinationDTO> getAllCentres() throws CentreNotFoundException {
        return centreVaccServ.getAllCentre();
    }

    @GetMapping("/centres/{centreId}")
    public CentreVaccinationDTO
    getCentreById(@PathVariable(name = "centreId") Long centreId) throws CentreNotFoundException {
        return centreVaccServ.getCentreById(centreId);
    }

    @PostMapping("/centres")
    public CentreVaccinationDTO
    saveCentreVaccination(
            @RequestBody CentreVaccinationDTO centreVaccinationDTO
            ){

            return centreVaccServ.saveCentreVaccination(centreVaccinationDTO);
    }

    @DeleteMapping("/centres/{centreId}")
    public void deleCentre(@PathVariable Long centreId){
        centreVaccServ.deleteCentre(centreId);
    }

    @PutMapping("/centres/{centreId}")
    public CentreVaccinationDTO updateCentre
            (@RequestBody CentreVaccinationDTO centreVaccinationDTO,
             @PathVariable(name = "centreId") Long centreId){

        centreVaccinationDTO.setId(centreId);

            return centreVaccServ.updateCentre(centreVaccinationDTO);
    }


}
