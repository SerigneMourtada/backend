package com.example.gestionvaccinationtestfirst.service.MaladieService;

import com.example.gestionvaccinationtestfirst.Excepyion.MaladieNotFoundException;
import com.example.gestionvaccinationtestfirst.model.MaladieDTO;

import java.util.List;

public interface MaladieServ{

    public MaladieDTO saveMaladie(MaladieDTO maladieDTO);

    public List<MaladieDTO> getAllMaladie();

    public MaladieDTO getMaladieById(Long maladieId);

    public void deleteMaladie(Long maladieId) throws MaladieNotFoundException;

    public MaladieDTO updateMaladie(MaladieDTO maladieDTO);


}
