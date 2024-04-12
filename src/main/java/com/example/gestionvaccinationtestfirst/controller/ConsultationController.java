package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ConsultationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.service.ConsultationService.ConsultationServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Consultation")
@AllArgsConstructor
@CrossOrigin("*")
public class ConsultationController{
    private ConsultationServ consultationServ;

    @GetMapping("/consultations")
    public List<ConsultationDTO> getAllConsultation(){
        return consultationServ.getAllConsultations();
    }

    @GetMapping("/consultations/{consultationId}")
    public ConsultationDTO getConsultationById(@PathVariable(name = "consultationId") Long consultationId) throws ConsultationNotFoundException {
        return consultationServ.getConsultationById(consultationId);
    }

    @PostMapping("/consultations/{enfantId}")
    public ConsultationDTO saveConsultation(@RequestBody ConsultationDTO consultationDTO,
                                            @PathVariable Long enfantId) throws EnfantNotFoundException {
        return consultationServ.saveConsultation(consultationDTO,enfantId);
    }

    @DeleteMapping("/consultations/{consultationId}")
    public  void deleteConsultation(@PathVariable Long consultationId) throws ConsultationNotFoundException {
        consultationServ.deleteConsultation(consultationId);
    }

    @PutMapping("/consultations/{consultationId}")
    public ConsultationDTO updateConsultation(@RequestBody ConsultationDTO consultationDTO,
                                              @PathVariable Long consultationId){
        consultationDTO.setId(consultationId);
        return consultationServ.updateConsultation(consultationDTO);
    }
}
