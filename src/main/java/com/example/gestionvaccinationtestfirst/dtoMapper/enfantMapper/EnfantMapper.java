package com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper;


import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class EnfantMapper {
    private ParentMapper parentMapper;
    public Enfant fromEnfantDTO(EnfantDTO enfantDTO){
        Enfant enfant=new Enfant();
        BeanUtils.copyProperties(enfantDTO,enfant);
        enfant.setParent(parentMapper.fromParentDTO(enfantDTO.getParentDTO()));
        return enfant;
    }

    public EnfantDTO fromEnfant(Enfant enfant){
        EnfantDTO enfantDTO=new EnfantDTO();
        BeanUtils.copyProperties(enfant,enfantDTO);
        enfantDTO.setParentDTO(parentMapper.fromParent(enfant.getParent()));
        return enfantDTO;
    }

}
