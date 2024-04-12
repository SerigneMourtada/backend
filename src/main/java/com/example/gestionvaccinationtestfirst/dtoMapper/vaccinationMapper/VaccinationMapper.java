package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinationMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapper;
import com.example.gestionvaccinationtestfirst.model.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinationMapper {

    private VaccinMapper vaccinMapper;


    private EnfantMapper enfantMapper;

    public Vaccination fromVaccinationDTO(VaccinationDTO vaccinationDTO){
        Vaccination vaccination=new Vaccination();
        BeanUtils.copyProperties(vaccinationDTO,vaccination);
        vaccination.setVaccin(vaccinMapper.fromVaccinDTO(vaccinationDTO.getVaccinDTO()));
        vaccination.setEnfant(enfantMapper.fromEnfantDTO(vaccinationDTO.getEnfantDTO()));
        return vaccination;
    }
    public VaccinationDTO fromVaccination(Vaccination vaccination){
        VaccinationDTO vaccinationDTO=new VaccinationDTO();
        BeanUtils.copyProperties(vaccination,vaccinationDTO);
        vaccinationDTO.setVaccinDTO(vaccinMapper.fromVaccin(vaccination.getVaccin()));
        vaccinationDTO.setEnfantDTO(enfantMapper.fromEnfant(vaccination.getEnfant()));
        return vaccinationDTO;
    }
}
