package com.example.gestionvaccinationtestfirst.service.RvService;

import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.DTos.RendezVousDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.RendezVousNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.rvMapper.RendezVousMapper;
import com.example.gestionvaccinationtestfirst.enumerations.Etat_Rendez_Vous;
import com.example.gestionvaccinationtestfirst.model.Parent;
import com.example.gestionvaccinationtestfirst.model.Rendez_Vous;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import com.example.gestionvaccinationtestfirst.repository.ParentRepository;
import com.example.gestionvaccinationtestfirst.repository.Rendez_Vous_Repository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RendezVousServImpl implements RendezVousServ{
    private RendezVousMapper rendezVousMapper;

    private Rendez_Vous_Repository rendezVousRepository;



    private final ParentRepository parentRepository;

    private ParentMapper parentMapper;

    private UtilisateurRepository utilisateurRepository;

    private UtilisateurMapper utilisateurMapper;

    @Override
    public List<RendezVousDTO> getListRendezVous() {
        List<Rendez_Vous> rendezVousList=rendezVousRepository.findAll();
        List<RendezVousDTO> rendezVousDTOList= rendezVousList.stream()
                .map(rv ->rendezVousMapper.fromRendezVous(rv)).toList();
        return rendezVousDTOList;
    }



    @Override
    public RendezVousDTO getRvById(Long rendez_vous_id){
        Rendez_Vous rendezVous=rendezVousRepository.findById(rendez_vous_id)
                .orElseThrow();
        return rendezVousMapper.fromRendezVous(rendezVous);
    }




    @Override
    public void deleteRendezVous(Long rendez_vous_id){
        rendezVousRepository.deleteById(rendez_vous_id);
    }



    @Override
    public RendezVousDTO saveRendezVous(RendezVousDTO rendezVousDTO, Long parentId,Long userId) throws ParentNotFoundException, UtilisateurNotFoundException {
        Parent parent=parentRepository.findById(parentId)
                .orElseThrow(()->new ParentNotFoundException("Parent Not Found"));
        Utilisateur utilisateur=utilisateurRepository.findById(userId)
                .orElseThrow(()->new UtilisateurNotFoundException("User Id Not Found"));

        ParentDTO parentDTO=parentMapper.fromParent(parent);

        UtilisateurDTO utilisateurDTO=utilisateurMapper.fromUtilisateur(utilisateur);

        rendezVousDTO.setParentDTO(parentDTO);

        rendezVousDTO.setUtilisateurDTO(utilisateurDTO);

        Rendez_Vous rendezVous=rendezVousMapper.fromRendezVousDTO(rendezVousDTO);

        Rendez_Vous rendezVous1=rendezVousRepository.save(rendezVous);

        return rendezVousMapper.fromRendezVous(rendezVous1);
    }



    @Override
    public RendezVousDTO updateRendezVous(RendezVousDTO rendezVousDTO) {
        Rendez_Vous rendezVous=rendezVousMapper.fromRendezVousDTO(rendezVousDTO);
        Rendez_Vous rendezVous1=rendezVousRepository.save(rendezVous);
        return rendezVousMapper.fromRendezVous(rendezVous1);
    }



    @Override
    public void confirmerRendezVous(Long rendez_vous_id) throws RendezVousNotFoundException {
       Rendez_Vous rv= rendezVousRepository.findById(rendez_vous_id)
                .orElseThrow(()->new RendezVousNotFoundException
                        ("Rendez Vous Not Found"));
       rv.setEtat_rendez_vous(Etat_Rendez_Vous.CONFIRMER);
       rendezVousRepository.save(rv);
    }




    @Override
    public void AnnulerRendezVous(Long rendez_vous) throws RendezVousNotFoundException {
        Rendez_Vous rv=rendezVousRepository.findById(rendez_vous)
                .orElseThrow(()->new RendezVousNotFoundException
                        ("Rendez Vous Not Found"));
        rv.setEtat_rendez_vous(Etat_Rendez_Vous.ANNULER);
        rendezVousRepository.save(rv);

    }


    @Override
    public void planifierRendezVous(Long rendez_vous_Id, LocalDate date) throws RendezVousNotFoundException {
        Rendez_Vous rendezVous=rendezVousRepository.findById(rendez_vous_Id)
                .orElseThrow(()->new RendezVousNotFoundException("Rendez Vous Not Found"));

        rendezVous.setDate(date);
        rendezVous.setEtat_rendez_vous(Etat_Rendez_Vous.PLANIFIER);
        rendezVousRepository.save(rendezVous);

    }


    //Autre Facon de fixer Un RV
    @Override
    public RendezVousDTO saveRendezVous(RendezVousDTO rendezVousDTO,Long userId,String telephone) throws UtilisateurNotFoundException, ParentNotFoundException {
        Utilisateur user=utilisateurRepository.findById(userId)
                .orElseThrow(()->new UtilisateurNotFoundException("User not Found"));

       Parent parent= parentRepository.findByCentreVaccination_Parents_Telephone(telephone);

       if(parent == null)
           throw  new ParentNotFoundException("Parent not Found");

       //Ajouter les rv dans la liste des rv du user recuperer
        /**user.getRendezVousList().add(rendezVousMapper.fromRendezVousDTO(rendezVousDTO));
         parent.setRendezVous(rendezVousMapper.fromRendezVousDTO(rendezVousDTO));

        rendezVousDTO.setUtilisateurDTO(utilisateurMapper.fromUtilisateur(user));
        rendezVousDTO.setParentDTO(parentMapper.fromParent(parent));

        rendezVousDTO.setEtat_rendez_vous(Etat_Rendez_Vous.ATTENTE_CONFIRMATION);

        Rendez_Vous rv=rendezVousMapper.fromRendezVousDTO(rendezVousDTO);

        Rendez_Vous rendez_vous= rendezVousRepository.save(rv);

        return rendezVousMapper.fromRendezVous(rendez_vous);**/
        return null;

    }


    @Override
    public List<RendezVousDTO> getAllRendezVous(String email) throws RendezVousNotFoundException {
        List<Rendez_Vous> rendezVousList=rendezVousRepository.findByUtilisateur_Email(email);

        List<RendezVousDTO> rendezVousDTOS=new ArrayList<>();
        if(rendezVousList == null)
            throw new RendezVousNotFoundException("Rendez Vous List is null");

        for(Rendez_Vous rv:rendezVousList){
            if(rv.getUtilisateur().getEmail().equals(email)){
                rendezVousDTOS.add(rendezVousMapper.fromRendezVous(rv));
            }
        }
        return rendezVousDTOS;

    }
}
