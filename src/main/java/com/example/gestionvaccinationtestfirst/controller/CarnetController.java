package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.CarnetVaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CarnetVaccinationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.service.carnetService.CarnetServ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Carnet")
public class CarnetController{
    private CarnetServ carnetServ;

    @PostMapping("/carnets/{enfantId}/{userId}")
    public CarnetVaccinationDTO saveCarnet(@RequestBody CarnetVaccinationDTO carnetVaccinationDTO,
                                           @PathVariable Long enfantId,
                                           @PathVariable Long userId) throws EnfantNotFoundException, UtilisateurNotFoundException {
        return carnetServ.saveCarnet(carnetVaccinationDTO,enfantId,userId);
    }


    @GetMapping("/carnets/{carnetId}")
    public CarnetVaccinationDTO getCarnetById(@PathVariable Long carnetId) throws CarnetVaccinationNotFoundException {
        return carnetServ.getCarnetById(carnetId);
    }

    @DeleteMapping("/carnets/{carnetId}")
    public void deleteCarnet(@PathVariable Long carnetId) throws CarnetVaccinationNotFoundException {
        carnetServ.deleteCarnet(carnetId);
    }

}
