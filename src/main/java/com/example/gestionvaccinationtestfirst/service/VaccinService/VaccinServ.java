package com.example.gestionvaccinationtestfirst.service.VaccinService;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;

import java.util.List;

public interface VaccinServ {
    public List<VaccinDTO> getAllVaccins();

    public VaccinDTO getVaccinById(Long vaccinId) throws VaccinNotFoundException;

    public void deleteVaccin(Long vaccinId);

    public VaccinDTO saveVaccin(VaccinDTO vaccinDTO);

    public VaccinDTO updateVaccin(VaccinDTO vaccinDTO);
}
