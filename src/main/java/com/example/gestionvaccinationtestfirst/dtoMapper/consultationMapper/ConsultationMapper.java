package com.example.gestionvaccinationtestfirst.dtoMapper.consultationMapper;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Consultation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultationMapper {
    private EnfantMapper enfantMapper;
    public ConsultationDTO fromConsultation(Consultation consultation){
        ConsultationDTO consultationDTO=new ConsultationDTO();
        BeanUtils.copyProperties(consultation,consultationDTO);
        consultationDTO.setEnfantDTO(enfantMapper.fromEnfant(consultation.getEnfant()));
        return consultationDTO;
    }

    public Consultation fromConsultationDTO(ConsultationDTO consultationDTO){
        Consultation consultation=new Consultation();
        BeanUtils.copyProperties(consultationDTO,consultation);
        consultation.setEnfant(enfantMapper.fromEnfantDTO(consultationDTO.getEnfantDTO()));
        return consultation;
    }
}
