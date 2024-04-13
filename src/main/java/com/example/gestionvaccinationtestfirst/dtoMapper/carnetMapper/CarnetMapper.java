package com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import lombok.AllArgsConstructor;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;
import org.mapstruct.Mapper;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CarnetMapper {
    /**public Carnet fromCarnetDTO(CarnetDTO CarnetDTO){
        Carnet carnet=new Carnet();
        carnet.setEnfant(enfantMapper.fromEnfantDTO(CarnetDTO.getEnfantDTO()));
        carnet.setParent(utilisateurMapper.fromUtilisateurDTO(CarnetDTO.getUtilisateurDTO()));
        return carnet;
    }**/
    Carnet asCarnet(CarnetDTO CarnetDTO);
    List<Carnet> asCarnets(List<CarnetDTO> carnetDTOs);
    List<CarnetDTO> asCarnetDTOs(List<Carnet> carnet);
    CarnetDTO asCarnetDTO(Carnet carnet);

    /**public CarnetDTO fromCarnet(Carnet carnet){
        CarnetDTO CarnetDTO=new CarnetDTO();
        CarnetDTO.setEnfantDTO(enfantMapper.fromEnfant(carnet.getEnfant()));
        CarnetDTO.setUtilisateurDTO(utilisateurMapper.fromUtilisateur(carnet.getUtilisateur()));

        return CarnetDTO;
    }**/

}
