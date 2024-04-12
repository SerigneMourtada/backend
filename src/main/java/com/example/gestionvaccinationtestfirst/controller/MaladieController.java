package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.Excepyion.MaladieNotFoundException;
import com.example.gestionvaccinationtestfirst.model.MaladieDTO;
import com.example.gestionvaccinationtestfirst.service.MaladieService.MaladieServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Maladie")
public class MaladieController {
    private MaladieServ maladieServ;

    @GetMapping("/maladies")
    public List<MaladieDTO> getAllMaladies(){
        return maladieServ.getAllMaladie();
    }

    @GetMapping("/maladies/{maladieId}")
    public MaladieDTO getMaladieById(@PathVariable Long maladieId){
        return maladieServ.getMaladieById(maladieId);
    }

    @PostMapping("/maladies")
    public MaladieDTO saveMaladie(@RequestBody MaladieDTO maladieDTO){
        return maladieServ.saveMaladie(maladieDTO);
    }

    @DeleteMapping("/maladies/{maladieId}")
    public void deleteMaladie(@PathVariable Long maladieId) throws MaladieNotFoundException {
        maladieServ.deleteMaladie(maladieId);
    }

    @PutMapping("/maladies/{maladieId}")
    public MaladieDTO updateMaladie(@RequestBody MaladieDTO maladieDTO,@PathVariable Long maladieId){
        maladieDTO.setId(maladieId);
        return maladieDTO;
    }
}
