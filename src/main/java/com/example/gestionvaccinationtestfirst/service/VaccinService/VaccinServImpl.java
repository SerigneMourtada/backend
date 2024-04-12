package com.example.gestionvaccinationtestfirst.service.VaccinService;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapper;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import com.example.gestionvaccinationtestfirst.repository.VaccinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VaccinServImpl implements VaccinServ{
    private VaccinRepository vaccinRepository;

    private VaccinMapper vaccinMapper;
    @Override
    public List<VaccinDTO> getAllVaccins(){
        List<Vaccin> vaccinList=vaccinRepository.findAll();
        List<VaccinDTO> vaccinDTOList=vaccinList.stream()
                .map(vaccin ->vaccinMapper.fromVaccin(vaccin)).toList();
        return vaccinDTOList;
    }

    @Override
    public VaccinDTO getVaccinById(Long vaccinId) throws VaccinNotFoundException {
        Vaccin vaccin=vaccinRepository.findById(vaccinId)
                .orElseThrow(()->new VaccinNotFoundException("Vaccin Not Found"));
        return vaccinMapper.fromVaccin(vaccin);
    }

    @Override
    public void deleteVaccin(Long vaccinId){
        vaccinRepository.deleteById(vaccinId);
    }

    @Override
    public VaccinDTO saveVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=vaccinRepository.save(vaccinMapper.fromVaccinDTO(vaccinDTO));
        return vaccinMapper.fromVaccin(vaccin);
    }

    @Override
    public VaccinDTO updateVaccin(VaccinDTO vaccinDTO) {
        Vaccin vaccin=vaccinRepository.save(vaccinMapper.fromVaccinDTO(vaccinDTO));
        return vaccinMapper.fromVaccin(vaccin);

    }
}
