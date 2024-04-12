package com.example.gestionvaccinationtestfirst.dtoMapper.maladieMapper;

import com.example.gestionvaccinationtestfirst.model.Maladie;
import com.example.gestionvaccinationtestfirst.model.MaladieDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MaladieMapper {

    public MaladieDTO fromMaladie(Maladie maladie){
        MaladieDTO maladieDTO=new MaladieDTO();
        BeanUtils.copyProperties(maladie,maladieDTO);
        return maladieDTO;
    }

    public Maladie fromMaladieDTO(MaladieDTO maladieDTO){
        Maladie maladie=new Maladie();
        BeanUtils.copyProperties(maladieDTO,maladie);
        return maladie;
    }
}
