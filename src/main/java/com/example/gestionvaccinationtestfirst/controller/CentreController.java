package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.service.CentreVaccinationService.CentreService;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CentreVaccination")
@AllArgsConstructor
@CrossOrigin("*")
public class CentreController {
    private CentreService centreService;

    @GetMapping("/centres")
    public List<CentreDTO> getAllCentres()  {
        return  centreService.getAllCentre();
    }

    @GetMapping("/centres/{centreId}")
    public CentreDTO
    getCentreById(@PathVariable(name = "centreId") Long centreId)  {
        return centreService.getCentreById(centreId);
    }

    @PostMapping("/centres")
    public CentreDTO
    saveCentreVaccination(
            @RequestBody CentreDTO CentreDTO
            ){

            return centreService.saveCentreVaccination(CentreDTO);
    }

    @DeleteMapping("/centres/{centreId}")
    public void deleCentre(@PathVariable Long centreId){
        centreService.deleteCentre(centreId);
    }

    @PutMapping("/centres/{centreId}")
    public CentreDTO updateCentre
            (@RequestBody CentreDTO CentreDTO,
             @PathVariable(name = "centreId") Long centreId){

        CentreDTO.setId(centreId);

            return centreService.updateCentre(CentreDTO);
    }


}
