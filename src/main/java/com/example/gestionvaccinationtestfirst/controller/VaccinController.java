package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapper;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import com.example.gestionvaccinationtestfirst.service.VaccinService.VaccinServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Vaccin")
@CrossOrigin("*")
public class VaccinController {
    private VaccinServ vaccinServ;

    @GetMapping("/vaccins")
    public List<VaccinDTO> getAllVaccin(){
        return vaccinServ.getAllVaccins();
    }

    @GetMapping("/vaccins/{vaccinId}")
    public VaccinDTO getVaccinById(@PathVariable(name = "vaccinId") Long vaccinId) throws VaccinNotFoundException {
        return vaccinServ.getVaccinById(vaccinId);
    }

    @DeleteMapping("/vaccins/{vaccinId}")
    public void deleteVaccin(@PathVariable(name = "vaccinId") Long vaccinId){
        vaccinServ.deleteVaccin(vaccinId);
    }

    @PostMapping("/vaccins")
    public VaccinDTO saveVaccin(@RequestBody VaccinDTO vaccinDTO){
        return vaccinServ.saveVaccin(vaccinDTO);
    }

    @PutMapping("/vaccins/{vaccinId}")
    public VaccinDTO updateVaccin(@RequestBody VaccinDTO vaccinDTO,@PathVariable(name ="vaccinId") Long vaccinId){
        vaccinDTO.setId(vaccinId);
        return vaccinServ.updateVaccin(vaccinDTO);
    }
}
