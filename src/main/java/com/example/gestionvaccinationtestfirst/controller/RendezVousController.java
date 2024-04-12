package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.RendezVousDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.RendezVousNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.service.RvService.RendezVousServ;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/RendezVous")
public class RendezVousController {
    private RendezVousServ rendezVousServ;

    @GetMapping("/rendez_vous/")
    public List<RendezVousDTO> getAllRendezVous(@RequestParam(name = "email") String email) throws RendezVousNotFoundException {
        return  rendezVousServ.getAllRendezVous(email);
    }

    @GetMapping("/rendez_vous")
    public List<RendezVousDTO> getAllRendezVous(){
        return rendezVousServ.getListRendezVous();
    }

    @GetMapping("/rendez_vous/{id}")
    public RendezVousDTO getRendezVousById(@PathVariable(name="id") Long id){
        return rendezVousServ.getRvById(id);
    }

    @DeleteMapping("/rendez_vous")
    public void deleteRendezVous(@PathVariable(name="id") Long id){
        rendezVousServ.deleteRendezVous(id);
    }

    @PostMapping("/rendez_vous/{parentId}/{userId}")
    public RendezVousDTO saveRendezVous(@RequestBody RendezVousDTO rendezVousDTO,
                                        @PathVariable(name="userId") Long userId,
                                        @PathVariable(name="parentId") Long parentId) throws ParentNotFoundException, UtilisateurNotFoundException {
        return rendezVousServ.saveRendezVous(rendezVousDTO,parentId,userId);
    }

    @PutMapping("/rendez_vous/{id}")
    public RendezVousDTO updateRendezVous(@RequestBody RendezVousDTO rendezVousDTO,
                                          @PathVariable(name="id") Long id){
        rendezVousDTO.setId(id);
        return rendezVousServ.updateRendezVous(rendezVousDTO);
    }

    @PostMapping("/rendez_vous/confirmation/{rvId}")
    public void confirmerRendezVous(@PathVariable(name="rvId") Long rvId) throws RendezVousNotFoundException {
         rendezVousServ.confirmerRendezVous(rvId);
    }

    @PostMapping("rendez_vous/annulation/{rvId}")
    public void AnnulerRendezVous(@PathVariable(name="rvId") Long rvId) throws RendezVousNotFoundException {
        rendezVousServ.AnnulerRendezVous(rvId);
    }

    @PutMapping("/rendez_vous/planifier/{rvId}")
    public void PlanierRendezVous(@PathVariable(name = "rvId") Long rvId,
                                  @RequestParam(name = "newDate") LocalDate newDate) throws RendezVousNotFoundException {
        rendezVousServ.planifierRendezVous(rvId,newDate);
    }
}
