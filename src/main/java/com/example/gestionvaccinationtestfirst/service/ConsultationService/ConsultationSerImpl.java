package com.example.gestionvaccinationtestfirst.service.ConsultationService;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ConsultationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.consultationMapper.ConsultationMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Consultation;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.repository.ConsulationRepository;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConsultationSerImpl implements ConsultationServ{
    private ConsulationRepository consulationRepository;

    private ConsultationMapper consultationMapper;

    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;


    @Override
    public List<ConsultationDTO> getAllConsultations() {
        List<Consultation> consultationList=consulationRepository.findAll();

        List<ConsultationDTO> consultationDTOList=consultationList.stream().map(consultation->consultationMapper.
                        fromConsultation(consultation))
                        .collect(Collectors.toList());

        return consultationDTOList;
    }

    @Override
    public ConsultationDTO getConsultationById(Long consultationId) throws ConsultationNotFoundException {
        Consultation consultation=consulationRepository.findById(consultationId)
                .orElseThrow(()->new ConsultationNotFoundException("Consultation not found"));
        return consultationMapper.fromConsultation(consultation);
    }

    @Override
    public void deleteConsultation(Long consultationId) throws ConsultationNotFoundException {
        consulationRepository.findById(consultationId)
                .orElseThrow(()->new ConsultationNotFoundException("Consultation not found"));

    }

    @Override
    public ConsultationDTO saveConsultation(ConsultationDTO consultationDTO, Long enfantId) throws EnfantNotFoundException {
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(()->new EnfantNotFoundException("Enfant not Found"));

        EnfantDTO enfantDTO=enfantMapper.fromEnfant(enfant);
        consultationDTO.setEnfantDTO(enfantDTO);
        Consultation consultation=consultationMapper.fromConsultationDTO(consultationDTO);
        enfant.getConsultations().add(consultation);
        Consultation consultation1=consulationRepository.save(consultation);
        return consultationMapper.fromConsultation(consultation1);
    }

    @Override
    public ConsultationDTO updateConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation=consultationMapper.fromConsultationDTO(consultationDTO);

        Consultation consultation1=consulationRepository.save(consultation);
        return consultationMapper.fromConsultation(consultation1);

    }
}
