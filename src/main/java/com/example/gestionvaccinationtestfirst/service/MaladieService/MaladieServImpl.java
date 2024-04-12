package com.example.gestionvaccinationtestfirst.service.MaladieService;

import com.example.gestionvaccinationtestfirst.Excepyion.MaladieNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.maladieMapper.MaladieMapper;
import com.example.gestionvaccinationtestfirst.model.Maladie;
import com.example.gestionvaccinationtestfirst.model.MaladieDTO;
import com.example.gestionvaccinationtestfirst.repository.MaladieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MaladieServImpl implements MaladieServ{
    private MaladieRepository maladieRepository;

    private MaladieMapper maladieMapper;


    @Override
    public MaladieDTO saveMaladie(MaladieDTO maladieDTO) {
        Maladie maladie=maladieMapper.fromMaladieDTO(maladieDTO);
        Maladie maladie1=maladieRepository.save(maladie);
        return maladieMapper.fromMaladie(maladie1);
    }

    @Override
    public List<MaladieDTO> getAllMaladie() {
        List<Maladie> maladieList=maladieRepository.findAll();
        List<MaladieDTO> maladieDTOList=maladieList.stream().map(maladie->maladieMapper.fromMaladie(maladie))
                .collect(Collectors.toList());
        return maladieDTOList;
    }

    @Override
    public MaladieDTO getMaladieById(Long maladieId) {
        return null;
    }

    @Override
    public void deleteMaladie(Long maladieId) throws MaladieNotFoundException {
        maladieRepository.findById(maladieId)
                .orElseThrow(()->new MaladieNotFoundException("Maladie Not Found"));

    }

    @Override
    public MaladieDTO updateMaladie(MaladieDTO maladieDTO){
        Maladie maladie=maladieMapper.fromMaladieDTO(maladieDTO);
        Maladie maladie1=maladieRepository.save(maladie);
        return maladieMapper.fromMaladie(maladie1);
    }
}
