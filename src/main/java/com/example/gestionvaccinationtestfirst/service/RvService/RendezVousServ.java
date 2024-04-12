package com.example.gestionvaccinationtestfirst.service.RvService;

import com.example.gestionvaccinationtestfirst.DTos.RendezVousDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.RendezVousNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RendezVousServ {

    public List<RendezVousDTO> getListRendezVous();

    public RendezVousDTO getRvById(Long rendez_vous_id);

    public void deleteRendezVous(Long rendez_vous_id);

    void planifierRendezVous(Long rendez_vou_Id, LocalDate date) throws RendezVousNotFoundException;

    public RendezVousDTO saveRendezVous(RendezVousDTO rendezVousDTO, Long userId, String telephone) throws UtilisateurNotFoundException,ParentNotFoundException;
    public RendezVousDTO saveRendezVous(RendezVousDTO rendezVousDTO,Long parentId,Long userId) throws ParentNotFoundException, UtilisateurNotFoundException;

    public RendezVousDTO updateRendezVous(RendezVousDTO rendezVousDTO);

    public void confirmerRendezVous(Long rendez_vous_id) throws RendezVousNotFoundException;

    public  void AnnulerRendezVous(Long rendez_vous) throws RendezVousNotFoundException;

    List<RendezVousDTO> getAllRendezVous(String email) throws RendezVousNotFoundException;
}
