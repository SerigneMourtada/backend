package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.service.ParentService.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Parent")
@AllArgsConstructor
@CrossOrigin("*")
public class ParentController {
    private ParentService parentService;

    @GetMapping("/parents")
    public List<ParentDTO> getAllParents(){

        return parentService.getAllParents();
    }

    @GetMapping("/parents/{parentId}")
    public ParentDTO getParentById(@PathVariable Long parentId) throws ParentNotFoundException {
        return parentService.getParent(parentId);
    }

    @DeleteMapping("/parents/{parentId}")
    public void deleteParent(@PathVariable Long parentId){
        parentService.deleteParent(parentId);
    }

    @PostMapping("/users/{email}")
    public ParentDTO saveParent(@RequestBody ParentDTO parentDTO,@RequestParam String email){
        return parentService.saveParent(parentDTO,email);
    }

    @PutMapping("/parents/{parentId}")
    public ParentDTO updateParent(@RequestBody ParentDTO parentDTO,@PathVariable Long parentId){
        parentDTO.setId(parentId);
        return parentService.updateParent(parentDTO);
    }

    @PostMapping("/parents/{centreId}")
    public ParentDTO saveParent(@RequestBody ParentDTO parentDTO,@PathVariable(name = "centreId") Long centreId) throws CentreNotFoundException {
        return parentService.saveParent(parentDTO,centreId);
    }
}
