package com.example.gestionvaccinationtestfirst.service.ConsultationService;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ConsultationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;

import java.util.List;

public interface ConsultationServ {

    public List<ConsultationDTO> getAllConsultations();

    public ConsultationDTO getConsultationById(Long consultationId) throws ConsultationNotFoundException;

    public void deleteConsultation(Long consultationId) throws ConsultationNotFoundException;

    public ConsultationDTO saveConsultation(ConsultationDTO consultationDTO,Long enfantId) throws EnfantNotFoundException;

    public ConsultationDTO updateConsultation(ConsultationDTO consultationDTO);
}
