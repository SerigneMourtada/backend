package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.service.ParentService.ParentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
@AllArgsConstructor
@CrossOrigin("*")
public class ParentController {
    private ParentService parentService;
    @Operation(summary = "Read Kpi", description = "Read an kpi by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParentDTO> getAllParents(){

        return parentService.getAllParents();
    }

    @Operation(summary = "Read Kpi", description = "Read an kpi by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/{parentId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
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
    public ParentDTO saveParent(@RequestBody ParentDTO parentDTO,@PathVariable(name = "centreId") Long centreId){
        return parentService.saveParent(parentDTO,centreId);
    }
}
