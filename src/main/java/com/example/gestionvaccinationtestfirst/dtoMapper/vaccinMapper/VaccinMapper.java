package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinMapper {
    public Vaccin fromVaccinDTO(VaccinDTO vaccinDTO){
        Vaccin vaccin=new Vaccin();
        BeanUtils.copyProperties(vaccinDTO,vaccin);
        return vaccin;
    }

    public VaccinDTO fromVaccin(Vaccin vaccin){
        VaccinDTO vaccinDTO=new VaccinDTO();
        BeanUtils.copyProperties(vaccin,vaccinDTO);
        return vaccinDTO;
    }
}
