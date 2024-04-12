package com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.model.CentreVaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CentreVaccMapper {

    public CentreVaccination fromCentreVaccinationDTO(CentreVaccinationDTO centreVaccinationDTO){
        CentreVaccination centreVaccination=new CentreVaccination();
        BeanUtils.copyProperties(centreVaccinationDTO,centreVaccination);
        return  centreVaccination;
    }

    public CentreVaccinationDTO fromCentreVaccination(CentreVaccination centreVaccination){
        CentreVaccinationDTO centreVaccinationDTO=new CentreVaccinationDTO();
        BeanUtils.copyProperties(centreVaccination,centreVaccinationDTO);
        return  centreVaccinationDTO;

    }
}
