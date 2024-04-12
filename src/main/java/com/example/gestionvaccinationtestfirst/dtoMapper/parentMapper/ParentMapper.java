package com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper;


import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreVaccMapper;
import com.example.gestionvaccinationtestfirst.model.Parent;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.beans.BeanUtils;


@Service
@AllArgsConstructor
public class ParentMapper {
    private CentreVaccMapper centreVaccMapper;

    public Parent fromParentDTO(ParentDTO parentDTO){
        Parent parent=new Parent();
        BeanUtils.copyProperties(parentDTO,parent);
        parent.setCentreVaccination(centreVaccMapper.fromCentreVaccinationDTO(parentDTO.getCentreVaccinationDTO()));
        return parent;
    }

    public ParentDTO fromParent(Parent parent){
        ParentDTO parentDTO=new ParentDTO();
        BeanUtils.copyProperties(parent,parentDTO);
        parentDTO.setCentreVaccinationDTO(centreVaccMapper.fromCentreVaccination((parent.getCentreVaccination())));
        return parentDTO;
    }


}
